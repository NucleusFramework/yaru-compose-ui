package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.themes.scale
import kotlin.math.ln

/**
 * A colorable, tappable banner — foundation-only, no Material3 dependency.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_banner.dart`. Yaru's spec is a flat
 * card with a hairline divider-color border, no shadow, optional selected
 * state painting an 80%-primary tint over the content.
 *
 * Layering reproduces Dart's `Material > InkWell > Card > Container > child`.
 * The OUTER chrome (Material + InkWell) draws at radius 12 over the full
 * caller bounds and carries the selected tint + hover overlay + click region.
 * The INNER chrome (Card body) is inset by Flutter's default Card margin of
 * 4 dp and uses radius `12 − 4/2 = 10` (BorderRadius.inner({all:4}) — see
 * `yaru.dart/lib/src/foundation/yaru_border_radius.dart`); it carries the
 * solid background fill, the optional surface tint, and the hairline border.
 *
 * Geometry / colours from yaru.dart:
 *  - outer `BorderRadius.circular(kYaruContainerRadius)` = 12 (L94, constants L8)
 *  - inner `borderRadius.inner(EdgeInsets.all(4.0))` = 10 (L111-113)
 *  - default `Card.margin = EdgeInsets.all(4)` (Flutter `Card` default, cited L113)
 *  - `defaultSurfaceTintColor = scaffoldBackgroundColor.scale(lightness: 0 light or 0.03 dark)` (L96-98)
 *  - background = `color ?? defaultSurfaceTintColor` (L106)
 *  - border = `theme.dividerColor`, `width: 0` (hairline ≈ 1 px) (L114)
 *  - hover overlay = `onSurface @ 0.1` (L103)
 *  - selected overlay = `primary @ 0.8` (L126)
 *  - elevation default = 1, drives M3 `surfaceTint` overlay (L109)
 *  - content padding default = `EdgeInsets.all(kYaruPagePadding)` = 20 (L14, constants L2)
 *  - optional [YaruFocusBorder] when `hasFocusBorder` is true
 */
@Composable
fun YaruBanner(
    modifier: Modifier = Modifier,
    onTap: (() -> Unit)? = null,
    onHover: ((Boolean) -> Unit)? = null,
    color: Color? = null,
    surfaceTintColor: Color? = null,
    // elevation default = 1 from yaru_banner.dart L109 (`elevation ?? 1`).
    elevation: Dp = 1.dp,
    selected: Boolean = false,
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_banner.dart:129. When `null`, fall back to the inherited
    // `LocalYaruTheme.focusBorders` (default true per inherited_theme.dart:305).
    hasFocusBorder: Boolean? = null,
    // EdgeInsets.all(kYaruPagePadding) from yaru_banner.dart L14 (kYaruPagePadding = 20).
    contentPadding: PaddingValues = PaddingValues(YaruConstants.PagePadding),
    content: @Composable () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    // Defensive per-edge clamp on caller-supplied padding: `Modifier.padding`
    // throws `IllegalArgumentException` on negative values, and a non-finite
    // Dp (NaN / +-Infinity) blows up `roundToPx()`. NaN bypasses
    // `coerceAtLeast` (NaN comparisons all return false), so reject
    // non-finite values via `isFinite()`. Mirrors YaruDialog / YaruTile.
    val layoutDirection = LocalLayoutDirection.current
    val safeContentPadding = contentPadding.coerceNonNegative(layoutDirection)
    // BorderRadius.circular(kYaruContainerRadius) from yaru_banner.dart L94 (= 12).
    val outerShape = RoundedCornerShape(YaruConstants.ContainerRadius)
    // BorderRadius.inner(EdgeInsets.all(4.0)) from yaru_banner.dart L111-113.
    // Per `yaru_border_radius.dart`, `inner` subtracts padding/2 from each
    // corner radius — so 12 − 2 = 10 dp.
    val innerShape = RoundedCornerShape(YaruConstants.ContainerRadius - 2.dp)
    // Default Card margin = EdgeInsets.all(4.0); cited in yaru_banner.dart L113
    // ("4 is the default margin").
    val cardMargin = 4.dp
    val borderColor = rememberYaruDividerColor()

    // defaultSurfaceTintColor = scaffoldBackgroundColor.scale(lightness: light?0:0.03)
    // from yaru_banner.dart L96-98.
    val defaultSurfaceTint = remember(scheme) {
        scheme.surface.scale(lightness = if (scheme.isLight) 0f else 0.03f)
    }
    // Material3 surface-tint overlay alpha = (4.5 * ln(elevation+1) + 2) / 100,
    // clamped at the M3 elevation-24 ceiling. At elevation 1 (Yaru default) this
    // resolves to ~0.0512 — matching Flutter's `Card` rendering when
    // `surfaceTintColor` is set on Material 3. Source: Flutter's
    // `_surfaceTintAlphaForElevation` (material/elevation_overlay.dart).
    // Defensive clamp: `ln(x)` with `x <= 0` returns NaN/-Infinity which would
    // poison the resulting alpha and the lerp below. NaN bypasses
    // `coerceAtLeast` (NaN comparisons all return false), so reject non-finite
    // values explicitly via `isFinite()`.
    val safeElevation =
        if (elevation.value.isFinite()) elevation.value.coerceAtLeast(0f) else 0f
    val elevationAlpha = ((4.5f * ln(safeElevation + 1f) + 2f) / 100f)
        .coerceIn(0f, 0.16f)
    // Defensive: caller-supplied colors with non-finite channels (e.g.
    // `Color.Unspecified`) would propagate through `lerp` and reach
    // `Modifier.background`, which Skia rejects.
    val baseBackground = sanitiseColor(color ?: defaultSurfaceTint)
    val safeSurfaceTint = surfaceTintColor?.let(::sanitiseColor)
    val tinted = if (safeSurfaceTint != null) {
        lerp(baseBackground, safeSurfaceTint, elevationAlpha)
    } else {
        baseBackground
    }

    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val focused by rememberKeyboardFocusedState(interactionSource)

    if (onHover != null) {
        // `rememberUpdatedState` so a fresh `onHover` lambda from the caller is
        // observed without restarting the effect (the effect only re-launches
        // when `hovered` changes, so without this the body would close over a
        // stale lambda from an earlier `hovered`-change recomposition).
        val currentOnHover by rememberUpdatedState(onHover)
        LaunchedEffect(hovered) {
            // Defensive: a caller-supplied onHover that throws must not propagate to Compose's exception handler.
            try {
                currentOnHover(hovered)
            } catch (ce: kotlinx.coroutines.CancellationException) {
                throw ce
            } catch (_: Throwable) {
            }
        }
    }

    // hoverColor = onSurface.withValues(alpha: 0.1) from yaru_banner.dart L103.
    val hoverOverlay = if (hovered && onTap != null) {
        scheme.onSurface.copy(alpha = 0.1f)
    } else {
        Color.Transparent
    }
    // primaryColor.withValues(alpha: 0.8) from yaru_banner.dart L126.
    val selectedOverlay = if (selected) scheme.primary.copy(alpha = 0.8f) else Color.Transparent

    // OUTER chrome: Material > InkWell layer. Spans the caller's full bounds
    // (e.g. the 200dp grid cell). Carries the selected tint (Material color),
    // the hover overlay (InkWell hoverColor), and the click region.
    // Defensive: do NOT prepend `modifier` here — the outermost layout node is the YaruFocusBorder (or fallback Box) below; applying caller modifiers there guarantees `.weight(1f)` / `.padding(...)` size the entire banner, focus ring included.
    val outerChrome: Modifier = Modifier
        .clip(outerShape)
        // Material(color: selected ? primary@0.8 : transparent) — yaru_banner.dart L124-127.
        .background(selectedOverlay)
        .let {
            if (onTap != null) {
                it
                    // Mirrors Dart `InkWell.mouseCursor` default
                    // (`WidgetStateMouseCursor.clickable` →
                    // `SystemMouseCursors.click`) — yaru_banner.dart:104
                    // forwards the user-provided cursor or falls through to
                    // the InkWell default.
                    .pointerHoverIcon(PointerIcon.Hand)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        role = Role.Button,
                        onClick = onTap,
                    )
                    // Defensive: announce selected state so screen readers describe whether the banner is currently active alongside its button role.
                    .semantics { this.selected = selected }
            } else if (onHover != null) {
                // Defensive: `clickable` is the only modifier feeding the interactionSource above, so without `onTap` the source receives no hover events and `onHover` would never fire. Attach `hoverable` so the independent `onHover` API still works on non-tappable banners.
                it.hoverable(interactionSource = interactionSource)
            } else it
        }
        // InkWell hover overlay — yaru_banner.dart L103. Painted ABOVE the
        // selected tint, BELOW the Card body, so it shows only in the 4dp
        // gutter (and through any transparency in the Card body).
        .background(hoverOverlay)

    // INNER chrome: Card body. 4dp gutter inside the outer chrome, 10dp
    // radius (12 − 4/2). Carries the solid background fill and the hairline
    // divider-color border. Padding is applied AFTER the background+border so
    // the content is inset by `contentPadding` within the card body.
    //
    // `fillMaxSize()` after `padding(cardMargin)` mirrors Flutter's
    // `Container(width: double.infinity, height: double.infinity)` inside the
    // Card body (yaru_banner.dart L116-121) — without this the card would
    // wrap to its content and ignore the parent's bounded height (e.g. the
    // 200 dp grid cell), which is the bug the user repeatedly flagged
    // ("le yaru banner est encore pete, il n'occupe pas du tout la meme
    // hauteur que la version flutter").
    val innerChrome: Modifier = Modifier
        .padding(cardMargin)
        .fillMaxSize()
        .clip(innerShape)
        .background(tinted)
        // BorderSide(color: theme.dividerColor, width: 0) — Flutter `width: 0`
        // paints a hairline (= 1 device pixel); 1.dp is the closest Compose
        // equivalent. yaru_banner.dart L114.
        .border(width = 1.dp, color = borderColor, shape = innerShape)
        .padding(safeContentPadding)

    // Body: outer + inner chrome stacked.
    //
    // ===== DO NOT REMOVE `contentAlignment = Alignment.Center` =====
    // The user has explicitly demanded that the banner's content (icon +
    // title + subtitle) be centered both horizontally and vertically inside
    // the bounded card. Several previous audit passes have repeatedly stripped
    // this alignment with the rationale "Dart `Container` without `alignment`
    // lays child at top-start" — that interpretation IS literally correct for
    // a bare `Container`, but Flutter's actual rendering of `YaruBanner.tile`
    // ends up centering the inner `YaruTile` because the surrounding
    // `Material > InkWell > Card` chain assigns intrinsic constraints that
    // make the tile naturally centered in the 200dp grid cell. Forcing
    // `Alignment.Center` here is the only way to reproduce that visual in
    // Compose without re-implementing the whole Flutter render-object
    // hierarchy. KEEP IT. Future audits MUST NOT remove it.
    val body: @Composable () -> Unit = {
        Box(modifier = outerChrome, contentAlignment = Alignment.Center) {
            Box(modifier = innerChrome, contentAlignment = Alignment.Center) {
                content()
            }
        }
    }

    if (showFocusBorder) {
        YaruFocusBorder(
            modifier = modifier,
            borderShape = outerShape,
            focused = focused && onTap != null,
        ) {
            body()
        }
    } else {
        // Defensive: route caller `modifier` onto the outermost layout node so caller-supplied sizing/weighting/test-tags reach the entire banner, not the inner outerChrome.
        Box(modifier = modifier) { body() }
    }
}

/**
 * Convenience overload that wraps a [YaruTile] inside a [YaruBanner].
 *
 * Mirrors `YaruBanner.tile` named ctor (yaru_banner.dart L23-55): the outer
 * banner uses `EdgeInsets.zero` and the [YaruTile] receives the original
 * padding (`kYaruPagePadding = 20`).
 */
@Suppress("DEPRECATION") // Mirrors Dart's deprecated_member_use_from_same_package suppression.
@Composable
fun YaruBannerTile(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    onTap: (() -> Unit)? = null,
    onHover: ((Boolean) -> Unit)? = null,
    color: Color? = null,
    surfaceTintColor: Color? = null,
    // elevation default = 1 from yaru_banner.dart L109.
    elevation: Dp = 1.dp,
    selected: Boolean = false,
    // Forwarded to [YaruBanner] — when `null`, falls back to the inherited
    // `LocalYaruTheme.focusBorders` (default true).
    hasFocusBorder: Boolean? = null,
    icon: @Composable (() -> Unit)? = null,
    subtitle: @Composable (() -> Unit)? = null,
    // EdgeInsets.all(kYaruPagePadding) from yaru_banner.dart L33 (= 20).
    contentPadding: PaddingValues = PaddingValues(YaruConstants.PagePadding),
) {
    YaruBanner(
        modifier = modifier,
        onTap = onTap,
        onHover = onHover,
        color = color,
        surfaceTintColor = surfaceTintColor,
        elevation = elevation,
        selected = selected,
        hasFocusBorder = hasFocusBorder,
        // EdgeInsets.zero on the outer banner — yaru_banner.dart L41.
        contentPadding = PaddingValues(0.dp),
    ) {
        YaruTile(
            title = title,
            leading = icon,
            subtitle = subtitle,
            contentPadding = contentPadding,
        )
    }
}

