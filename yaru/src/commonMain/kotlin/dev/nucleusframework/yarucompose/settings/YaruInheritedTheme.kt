package dev.nucleusframework.yarucompose.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.nucleusframework.yarucompose.themes.YaruTheme
import dev.nucleusframework.yarucompose.themes.YaruVariant
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

/**
 * Snapshot of the resolved Yaru theme for descendants of [YaruThemeRoot].
 *
 * Mirrors `YaruThemeData` from `yaru.dart/lib/src/settings/inherited_theme.dart`
 * (lines 295-306). Flutter-only fields (`extensions`, `pageTransitionsTheme`,
 * `useMaterial3`, `visualDensity`) are intentionally omitted — they have no
 * Compose Material3 equivalent.
 */
@Immutable
data class YaruThemeData(
    /** Specifies the theme variant. Mirrors Dart `variant`. */
    val variant: YaruVariant? = null,
    /** Whether to use high contrast colors. Mirrors Dart `highContrast`. */
    val highContrast: Boolean? = null,
    /**
     * Whether a dark theme is used. Mirrors Dart `themeMode` resolved against
     * platform brightness — Compose callers do the system-mode resolution
     * upstream and pass a concrete boolean here.
     */
    val isDark: Boolean? = null,
    /** Mirrors Dart `statusShapes` — driven by the GTK setting stream. */
    val statusShapes: Boolean? = null,
    /**
     * Whether to draw focus borders. Mirrors Dart `focusBorders` (declared
     * `bool?` with default `true`; modeled here as non-nullable).
     */
    val focusBorders: Boolean = true,
)

/** CompositionLocal providing the active [YaruThemeData] to descendants. */
val LocalYaruTheme = compositionLocalOf<YaruThemeData?> { null }

/**
 * Wraps [content] with a Material/Yaru theme whose variant and high-contrast
 * flag follow the supplied [data] and live updates from [settings].
 *
 * Equivalent to the `YaruTheme` widget in Dart (the Composable named
 * [dev.nucleusframework.yarucompose.themes.YaruTheme] applies the Material3 theme;
 * this wrapper additionally exposes [YaruThemeData] through [LocalYaruTheme]).
 */
@Composable
fun YaruThemeRoot(
    data: YaruThemeData = YaruThemeData(),
    settings: YaruSettings = remember { NoOpYaruSettings() },
    isSystemDark: Boolean = false,
    isSystemHighContrast: Boolean = false,
    content: @Composable () -> Unit,
) {
    // Defensive: key on `settings` so swapping platforms clears the stale detected variant before the new DisposableEffect resolves it.
    var detectedVariant by remember(settings) { mutableStateOf<YaruVariant?>(null) }
    // Defensive: YaruSwitch reads `LocalYaruTheme.current?.statusShapes`; without this the documented GTK-stream wiring would be a silent no-op.
    var detectedStatusShapes by remember(settings) { mutableStateOf<Boolean?>(null) }
    DisposableEffect(settings) {
        // Defensive: a misbehaving platform settings impl must not crash composition during init or initial read.
        runCatching { settings.init() }
        detectedVariant = runCatching {
            resolveAccentColorVariant(settings.getAccentColor())
                ?: resolveGtkThemeVariant(settings.getThemeName())
        }.getOrNull()
        detectedStatusShapes = runCatching { settings.getStatusShapes() }.getOrNull()
        onDispose {
            // Defensive: build a fresh dispose scope per disposal so a hot-reload reusing the same `settings` instance never lands on a previously-cancelled scope.
            val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
            scope.launch {
                try {
                    settings.dispose()
                } catch (ce: CancellationException) {
                    // Defensive: re-throw CancellationException so structured concurrency is preserved if `dispose()` is cancelled mid-suspend.
                    throw ce
                } catch (_: Throwable) {
                    // Defensive: swallow non-cancellation dispose-time errors so cleanup of the dispose scope still runs.
                } finally {
                    scope.cancel()
                }
            }
        }
    }

    LaunchedEffect(settings) {
        // Defensive: a platform settings flow that errors must not crash the Compose tree; swallow and keep the last resolved variant.
        settings.accentColorChanged.catch { }.collect { color ->
            // Defensive: `Flow.catch` only catches upstream errors; `getThemeName()` thrown from inside `collect { ... }` would kill the collector. Protect the synchronous getter so a misbehaving platform impl can't freeze the theme.
            val fallbackName = runCatching { settings.getThemeName() }.getOrNull()
            detectedVariant = resolveAccentColorVariant(color)
                ?: resolveGtkThemeVariant(fallbackName)
        }
    }
    LaunchedEffect(settings) {
        // Defensive: a platform settings flow that errors must not crash the Compose tree; swallow and keep the last resolved variant.
        settings.themeNameChanged.catch { }.collect { name ->
            // Defensive: same hazard as above — protect the synchronous `getAccentColor()` getter so a throw can't kill the themeName collector.
            val fallbackAccent = runCatching { settings.getAccentColor() }.getOrNull()
            detectedVariant = resolveAccentColorVariant(fallbackAccent)
                ?: resolveGtkThemeVariant(name)
        }
    }
    LaunchedEffect(settings) {
        // Defensive: live-update `statusShapes` so YaruSwitch (the sole consumer) reflects the GTK a11y setting at runtime instead of staying frozen at the initial read.
        settings.statusShapesChanged.catch { }.collect { value ->
            detectedStatusShapes = value
        }
    }

    val resolved = data.copy(
        variant = data.variant ?: detectedVariant ?: YaruVariant.Orange,
        highContrast = data.highContrast ?: isSystemHighContrast,
        isDark = data.isDark ?: isSystemDark,
        statusShapes = data.statusShapes ?: detectedStatusShapes,
    )

    CompositionLocalProvider(LocalYaruTheme provides resolved) {
        YaruTheme(
            isDark = resolved.isDark == true,
            highContrast = resolved.highContrast == true,
            variant = resolved.variant ?: YaruVariant.Orange,
            content = content,
        )
    }
}

/**
 * Resolve a Yaru variant from a GTK theme name (Adwaita / Yaru-* family).
 * Returns `null` if the name is unknown.
 */
private fun resolveGtkThemeVariant(name: String?): YaruVariant? {
    val key = name?.removeSuffix("-dark") ?: return null
    return when (key) {
        "Adwaita" -> YaruVariant.AdwaitaBlue
        "Adwaita-green", "Yaru-green" -> YaruVariant.AdwaitaGreen
        "Adwaita-orange" -> YaruVariant.AdwaitaOrange
        "Adwaita-pink", "Yaru-pink" -> YaruVariant.AdwaitaPink
        "Adwaita-purple" -> YaruVariant.AdwaitaPurple
        "Adwaita-red" -> YaruVariant.AdwaitaRed
        "Adwaita-slate", "Yaru-slate" -> YaruVariant.AdwaitaSlate
        "Adwaita-teal", "Yaru-teal" -> YaruVariant.AdwaitaTeal
        "Adwaita-yellow", "Yaru-yellow" -> YaruVariant.AdwaitaYellow
        "Yaru" -> YaruVariant.Orange
        "Yaru-prussiangreen" -> YaruVariant.PrussianGreen
        "Yaru-bark" -> YaruVariant.Bark
        "Yaru-blue" -> YaruVariant.Blue
        "Yaru-wartybrown" -> YaruVariant.WartyBrown
        "Yaru-magenta" -> YaruVariant.Magenta
        "Yaru-olive" -> YaruVariant.Olive
        "Yaru-purple" -> YaruVariant.Purple
        "Yaru-sage" -> YaruVariant.Sage
        "Yaru-red" -> YaruVariant.Red
        "Yaru-viridian" -> YaruVariant.Viridian
        else -> null
    }
}

/**
 * Resolve a Yaru variant from a GNOME accent-color name (Ubuntu 24.10+).
 * Returns `null` for unknown values or when the system does not expose one.
 */
private fun resolveAccentColorVariant(name: String?): YaruVariant? = when (name) {
    "blue" -> YaruVariant.Blue
    "teal", "Yaru-teal" -> YaruVariant.AdwaitaTeal
    "green", "Yaru-green" -> YaruVariant.AdwaitaGreen
    "yellow", "Yaru-yellow" -> YaruVariant.AdwaitaYellow
    "orange" -> YaruVariant.Orange
    "red" -> YaruVariant.Red
    "pink", "Yaru-pink" -> YaruVariant.Magenta
    "purple" -> YaruVariant.Purple
    "slate", "Yaru-slate" -> YaruVariant.AdwaitaSlate
    "brown" -> YaruVariant.WartyBrown
    else -> null
}
