package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import dev.nucleusframework.yarucompose.foundation.YaruEasing
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isHighContrast
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.themes.scale

/**
 * A Yaru-styled dialog scaffold.
 *
 * Mirrors `YaruSimpleDialog` / `AlertDialog + YaruDialogTitleBar` usage from
 * `yaru.dart/example/lib/pages/dialog_page.dart`. Renders a window-radius
 * surface with an optional [YaruDialogTitleBar] at the top, a [content] body,
 * and an optional trailing [actions] row.
 *
 * The dialog is dismissed via [onDismissRequest]; pass a no-op (or `null`)
 * to make it modal — when [dismissOnClickOutside] / [dismissOnBackPress] are
 * `false` the only way to close becomes the close button or an explicit
 * action button (mirrors the `isCloseable=false` flow in the Dart example).
 *
 * Animation: fade-only enter and exit, 150ms with `Curves.easeOut`. Mirrors
 * Flutter's default `_buildMaterialDialogTransitions` (a single
 * `FadeTransition(opacity: CurvedAnimation(parent, curve: Curves.easeOut))`
 * over `_dialogDefaultBarrierDuration = 150ms`); no scale, no slide.
 * `YaruTheme` does not override the dialog transition —
 * `pageTransitionsTheme: YaruPageTransitionsTheme.horizontal` only affects
 * `PageRoute` builders, not `_DialogRoute`.
 */
@Composable
fun YaruDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title: @Composable (() -> Unit)? = null,
    titleLeading: @Composable (() -> Unit)? = null,
    isClosable: Boolean = true,
    onClose: (() -> Unit)? = onDismissRequest,
    dismissOnBackPress: Boolean = isClosable,
    dismissOnClickOutside: Boolean = isClosable,
    contentPadding: PaddingValues = PaddingValues(YaruConstants.PagePadding),
    actions: @Composable (() -> Unit)? = null,
    actionsPadding: PaddingValues = PaddingValues(
        start = YaruConstants.PagePadding,
        end = YaruConstants.PagePadding,
        bottom = YaruConstants.PagePadding,
    ),
    actionsSpacing: Dp = 8.dp,
    content: @Composable () -> Unit,
) {
    YaruAnimatedDialogHost(
        onDismissRequest = onDismissRequest,
        dismissOnBackPress = dismissOnBackPress,
        dismissOnClickOutside = dismissOnClickOutside,
    ) { requestExit ->
        YaruDialogSurface(modifier = modifier) {
            if (title != null || titleLeading != null || isClosable) {
                YaruDialogTitleBar(
                    leading = titleLeading,
                    title = title,
                    isClosable = isClosable,
                    onClose = if (onClose != null) {
                        // Route the close button through the exit animation
                        // when it points to the parent's dismiss handler;
                        // custom handlers run as-is so callers can perform
                        // side-effects (e.g. setting result state) before
                        // dismissal.
                        if (onClose === onDismissRequest) {
                            { requestExit() }
                        } else {
                            onClose
                        }
                    } else {
                        null
                    },
                    backgroundColor = dialogBackgroundColor(),
                )
            }
            // Defensive per-edge clamp: `Modifier.padding(PaddingValues)`
            // throws `IllegalArgumentException` on any negative edge.
            val layoutDirection = LocalLayoutDirection.current
            val safeContentPadding = contentPadding.coerceNonNegative(layoutDirection)
            Box(modifier = Modifier.padding(safeContentPadding)) { content() }
            if (actions != null) {
                // Defensive clamp via the canonical `Dp.sanitise()` foundation
                // helper: `Arrangement.spacedBy(-1.dp)` throws
                // `IllegalArgumentException`, and a non-finite Dp (NaN /
                // ±Infinity) blows up `roundToPx()` inside the arrangement.
                val safeSpacing = actionsSpacing.sanitise()
                val safeActionsPadding = actionsPadding.coerceNonNegative(layoutDirection)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(safeActionsPadding),
                    horizontalArrangement = Arrangement.spacedBy(
                        safeSpacing,
                        alignment = androidx.compose.ui.Alignment.End,
                    ),
                ) {
                    actions()
                }
            }
        }
    }
}

/**
 * Hosts a Compose [Dialog] with Material's default dialog transition:
 * 150ms `easeOut` fade only (no scale, no slide), mirroring Flutter's
 * `_buildMaterialDialogTransitions` and `_dialogDefaultBarrierDuration`.
 *
 * Compose's `Dialog` has no built-in transitions and unmounts immediately
 * when removed from composition, so we keep an internal
 * [MutableTransitionState] that drives [AnimatedVisibility]. Dismiss
 * requests (back press, outside click, close button via [requestExit]) flip
 * the visibility off; once the exit animation idles we forward the real
 * `onDismissRequest` to the caller, which in turn unmounts the host.
 */
@Composable
internal fun YaruAnimatedDialogHost(
    onDismissRequest: () -> Unit,
    dismissOnBackPress: Boolean,
    dismissOnClickOutside: Boolean,
    content: @Composable (requestExit: () -> Unit) -> Unit,
) {
    // Start hidden, then flip to visible on first composition so the enter
    // transition runs (Flutter's `_buildMaterialDialogTransitions` plays on
    // mount with the route's animation driver).
    val visibility = remember { MutableTransitionState(false) }
    LaunchedEffect(Unit) { visibility.targetState = true }

    // Track whether the dialog has actually become visible at least once.
    // Without this latch, the early `(false, idle, false)` state on first
    // composition would immediately fire `onDismissRequest`, unmounting the
    // dialog before its enter animation runs.
    var hasShown by remember { mutableStateOf(false) }
    LaunchedEffect(visibility.currentState) {
        if (visibility.currentState) hasShown = true
    }

    val requestExit: () -> Unit = remember(visibility) {
        { visibility.targetState = false }
    }

    // `rememberUpdatedState` so a fresh `onDismissRequest` lambda from the
    // caller is observed without rekeying the effect — the LaunchedEffect
    // below is keyed on `Unit` and would otherwise close over the lambda
    // captured at first launch, which is stale if the caller swapped
    // handlers between mount and the exit animation finishing.
    val currentOnDismissRequest by rememberUpdatedState(onDismissRequest)

    // Latch so the parent's `onDismissRequest` fires exactly once even if the
    // idle/hidden condition holds across multiple recompositions before the
    // host is unmounted (e.g. caller defers state update, or recomposes while
    // the LaunchedEffect is queued). Without this, a re-entry into the branch
    // after the effect already ran could schedule a second dispatch.
    var dismissed by remember { mutableStateOf(false) }
    val shouldDismiss = hasShown &&
        !visibility.targetState &&
        visibility.isIdle &&
        !visibility.currentState &&
        !dismissed
    if (shouldDismiss) {
        LaunchedEffect(Unit) {
            dismissed = true
            // Defensive: a caller-supplied onDismissRequest that throws must not propagate to Compose's exception handler and tear down the host.
            try {
                currentOnDismissRequest()
            } catch (ce: kotlinx.coroutines.CancellationException) {
                throw ce
            } catch (_: Throwable) {
            }
        }
    }

    Dialog(
        onDismissRequest = requestExit,
        properties = DialogProperties(
            dismissOnBackPress = dismissOnBackPress,
            dismissOnClickOutside = dismissOnClickOutside,
            // Keep Compose's default platform sizing. On desktop CMP a
            // `Dialog` is a native OS window, and `usePlatformDefaultWidth =
            // false` combined with `Modifier.fillMaxSize()` blows the window
            // up to the entire screen ("occupe tout l'écran"). With the
            // default `true`, the window sizes to its content — which
            // `YaruDialogSurface` clamps via `widthIn(min=280, max=560)` to
            // mirror Material's `_DialogDefaults.minWidth = 280` /
            // `maxWidth = 560` from `material/dialog.dart`.
        ),
    ) {
        // Mirrors Flutter's `_buildMaterialDialogTransitions`
        // (material/dialog.dart): a single `FadeTransition` driven by
        // `CurvedAnimation(parent, curve: Curves.easeOut)` over the
        // route's animation duration (`_dialogDefaultBarrierDuration =
        // Duration(milliseconds: 150)`). No scale, no slide. Wrap-content
        // sized so the dialog window measures its content intrinsically.
        AnimatedVisibility(
            visibleState = visibility,
            enter = fadeIn(animationSpec = tween(durationMillis = 150, easing = YaruEasing.EaseOut)),
            exit = fadeOut(animationSpec = tween(durationMillis = 150, easing = YaruEasing.EaseOut)),
        ) {
            content(requestExit)
        }
    }
}

/**
 * Yaru dialog chrome: window-radius corners, menu-tinted background, and
 * the dark/HC border from `_createDialogTheme` in `common_themes.dart`.
 * Extracted so [YaruDialog] and the inline dialog in `BannerPage` share the
 * same surface treatment under the animated host.
 */
@Composable
internal fun YaruDialogSurface(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val shape = RoundedCornerShape(YaruConstants.WindowRadius)
    val dialogBg = dialogBackgroundColor()
    val borderColor: Color = if (scheme.isLight) {
        Color.Transparent
    } else {
        Color.White.copy(alpha = if (scheme.isHighContrast) 1f else 0.2f)
    }
    val borderModifier = if (scheme.isLight) Modifier else Modifier.border(
        width = 1.dp,
        color = borderColor,
        shape = shape,
    )
    // Mirrors Material's `_DialogDefaults.minWidth = 280` and
    // `maxWidth = 560` from `material/dialog.dart` (the `Dialog` widget wraps
    // its child in a `ConstrainedBox(BoxConstraints(minWidth: 280,
    // maxWidth: 560))`). `width(IntrinsicSize.Max)` lets the dialog size
    // itself to the widest child (title bar, content, actions); `widthIn`
    // then clamps so a verbose subtitle can't push past 560dp.
    Box(
        modifier = modifier
            .width(IntrinsicSize.Max)
            .widthIn(min = 280.dp, max = 560.dp)
            // Material 3 `_DialogDefaultsM3.elevation = 6.0` (material/dialog.dart).
            // Yaru does not override `dialogTheme.elevation` in
            // `_createDialogTheme` (common_themes.dart L315-331), so the M3
            // default of 6 dp applies. Painted before clip/background so the
            // shadow falls outside the dialog body, mirroring Flutter's
            // `Material(elevation: 6)` chrome.
            .shadow(elevation = 6.dp, shape = shape)
            .clip(shape)
            .background(color = dialogBg, shape = shape)
            .then(borderModifier),
    ) {
        Column { content() }
    }
}

/**
 * `_createMenuBg(colorScheme)` from `common_themes.dart`:
 * `surface.scale(lightness: light ? 0 : -0.2)` — slightly darkens the dark
 * surface so the dialog reads above the page.
 */
@Composable
internal fun dialogBackgroundColor(): Color {
    val scheme = LocalYaruColorScheme.current
    return scheme.surface.scale(lightness = if (scheme.isLight) 0f else -0.2f)
}

