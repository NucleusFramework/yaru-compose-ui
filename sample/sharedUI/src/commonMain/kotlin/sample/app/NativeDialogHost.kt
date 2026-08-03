package sample.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import dev.nucleusframework.yarucompose.themes.YaruVariant

/**
 * Opens a dialog as a real top-level window.
 *
 * Only the desktop app can supply one: `YaruDecoratedDialog` needs the
 * `NucleusApplicationScope` that `nucleusApplication { }` hands to `main`, and
 * that scope cannot be reached from inside the composition. The desktop entry
 * point provides an implementation through [LocalNativeDialogHost]; every other
 * target leaves it `null` and the caller falls back to a Compose `Dialog`.
 */
fun interface NativeDialogHost {
    @Composable
    fun Dialog(
        title: String,
        onCloseRequest: () -> Unit,
        content: @Composable () -> Unit,
    )
}

/** @see NativeDialogHost */
val LocalNativeDialogHost = staticCompositionLocalOf<NativeDialogHost?> { null }

/**
 * The theme arguments `App` resolved, so a native dialog can re-apply them.
 *
 * A [NativeDialogHost] dialog is its own window with its own composition, and
 * composition locals do not cross that boundary — but a value read here, in the
 * parent, is captured by the content lambda and travels with it.
 */
data class SampleThemeSpec(
    val isDark: Boolean,
    val highContrast: Boolean,
    val variant: YaruVariant,
)

/** @see SampleThemeSpec */
val LocalSampleThemeSpec = staticCompositionLocalOf {
    SampleThemeSpec(isDark = false, highContrast = false, variant = YaruVariant.Orange)
}
