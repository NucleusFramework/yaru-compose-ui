package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.toggleableState
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants

/**
 * A flexible list tile with leading / title / subtitle / trailing slots.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_list_tile.dart`.
 *
 * Use [YaruListTile] for a rounded standalone tile, or [YaruListTileSquare]
 * inside a [YaruTileList] to share corners with neighbours.
 */
@Composable
fun YaruListTile(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    leading: @Composable (() -> Unit)? = null,
    subtitle: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    onTap: (() -> Unit)? = null,
    enabled: Boolean = true,
    centerTitle: Boolean = false,
    // `_horizontalGap = 12.0` / `_verticalGap = 8.0` from yaru_list_tile.dart.
    horizontalGap: Dp = 12.dp,
    verticalGap: Dp = 8.dp,
    contentPadding: PaddingValues? = null,
    shape: Shape = RoundedCornerShape(YaruConstants.ButtonRadius),
    interactionSource: MutableInteractionSource? = null,
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders` from
    // yaru_list_tile.dart:197. When `null`, fall back to the inherited
    // `LocalYaruTheme.focusBorders` (default true per inherited_theme.dart:305).
    // Pass `false` when the caller already wraps its own ring (e.g.
    // `YaruMasterTile`) to avoid stacking two accent rings.
    hasFocusBorder: Boolean? = null,
    // Semantic role advertised when the tile is tappable. Defaults to
    // [Role.Button]; specialised wrappers (e.g. [YaruRadioListTile],
    // [YaruSwitchListTile], [YaruCheckboxListTile]) override this to expose
    // the correct toggle/radio role to assistive technologies.
    role: Role = Role.Button,
    // Defensive: state announcement for screen readers — set when the tile represents an on/off / checkbox state (`toggleableState`) or a one-of-many selection (`selected`). Without these, TalkBack/VoiceOver announce only the role, never the current state.
    toggleableState: ToggleableState? = null,
    selected: Boolean? = null,
) {
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    // Defensive clamps via the canonical `Dp.sanitise()` foundation helper:
    // `Modifier.padding` and `Spacer.width` throw on negative `Dp`, and a
    // non-finite Dp (NaN / +-Infinity) blows up `roundToPx()`.
    val safeHorizontalGap = horizontalGap.sanitise()
    val safeVerticalGap = verticalGap.sanitise()
    val layoutDirection = LocalLayoutDirection.current
    // Mirrors `YaruListTile.build`:
    //   ConstrainedBox(constraints: BoxConstraints(minHeight: 54)) — fixed 54dp.
    //   Padding default = EdgeInsets.symmetric(horizontal: horizontalGap, vertical: verticalGap).
    //   Title uses textTheme.labelLarge, subtitle uses textTheme.labelMedium
    //   (also matches `_createListTileTheme.titleTextStyle / subtitleTextStyle`).
    val padding = contentPadding?.coerceNonNegative(layoutDirection)
        ?: PaddingValues(horizontal = safeHorizontalGap, vertical = safeVerticalGap)
    val minHeight = 54.dp
    // Resolve the tap callback once: only enabled tiles with a handler are tappable.
    // Mirrors `onTap: enabled ? onTap : null` in yaru_list_tile.dart:150.
    val effectiveOnTap = onTap?.takeIf { enabled }
    val tappable = effectiveOnTap != null
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val ownInteraction = remember { MutableInteractionSource() }
    val src = interactionSource ?: ownInteraction
    val focused by rememberKeyboardFocusedState(src)

    val row: @Composable () -> Unit = {
        // BoxWithConstraints so a `fillMaxWidth` trailing child (text field,
        // combo box) cannot be measured with infinite max width — that would
        // consume the whole row and leave the title Column at 0 px, wrapping
        // each glyph onto its own line. Cap trailing at half the tile; title
        // `weight(1f)` takes the rest. Flutter's `Expanded` title + intrinsic
        // trailing relies on the same bounded-width Row.
        BoxWithConstraints {
            val maxTrailingWidth = maxWidth * 0.5f
            val rowModifier = Modifier
                .fillMaxWidth()
                .heightIn(min = minHeight)
                .clip(shape)
                .let {
                    if (effectiveOnTap != null) {
                        it
                            // Mirrors Dart `InkWell.mouseCursor` default
                            // (`WidgetStateMouseCursor.clickable` →
                            // `SystemMouseCursors.click`) used by `YaruListTile`'s
                            // inner `InkWell` (yaru_list_tile.dart:151).
                            .pointerHoverIcon(PointerIcon.Hand)
                            .clickable(
                                interactionSource = src,
                                indication = androidx.compose.foundation.LocalIndication.current,
                                role = role,
                                onClick = effectiveOnTap,
                            )
                            // Defensive: merge state into the clickable's semantics node so screen readers announce on/off / selected state alongside the role.
                            .let { m ->
                                if (toggleableState != null || selected != null) {
                                    m.semantics {
                                        if (toggleableState != null) this.toggleableState = toggleableState
                                        if (selected != null) this.selected = selected
                                    }
                                } else m
                            }
                    } else it
                }
                .padding(padding)
            Row(modifier = rowModifier, verticalAlignment = Alignment.CenterVertically) {
                if (leading != null) {
                    leading()
                    Spacer(Modifier.width(safeHorizontalGap))
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = if (centerTitle) Alignment.CenterHorizontally else Alignment.Start,
                ) {
                    val typography = LocalYaruTypography.current
                    val scheme = LocalYaruColorScheme.current
                    CompositionLocalProvider(
                        LocalYaruTextStyle provides disabledTextStyle(typography.labelLarge, enabled, scheme),
                    ) {
                        title()
                    }
                    if (subtitle != null) {
                        CompositionLocalProvider(
                            LocalYaruTextStyle provides disabledTextStyle(typography.labelMedium, enabled, scheme),
                        ) {
                            subtitle()
                        }
                        // Trailing 1dp gap below subtitle, mirroring Dart's
                        // `SizedBox(height: 1)` in yaru_list_tile.dart.
                        Spacer(Modifier.height(1.dp))
                    }
                }
                if (trailing != null) {
                    Spacer(Modifier.width(safeHorizontalGap))
                    Box(modifier = Modifier.widthIn(max = maxTrailingWidth)) {
                        trailing()
                    }
                }
            }
        }
    }

    if (tappable && showFocusBorder) {
        // The outer focus border tracks the row's clickable focus state via the
        // shared interactionSource — never via onFocusChanged on a parent.
        YaruFocusBorder(modifier = modifier, borderShape = shape, focused = focused) { row() }
    } else {
        Box(modifier = modifier) { row() }
    }
}

/** Convenience overload that takes plain strings for title/subtitle. */
@Composable
fun YaruListTile(
    titleText: String,
    modifier: Modifier = Modifier,
    subtitleText: String? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    onTap: (() -> Unit)? = null,
    enabled: Boolean = true,
    centerTitle: Boolean = false,
    contentPadding: PaddingValues? = null,
    shape: Shape = RoundedCornerShape(YaruConstants.ButtonRadius),
) {
    // Defensive: empty `subtitleText` would still install a non-null subtitle composable, which the parent renders with a CompositionLocalProvider plus a trailing 1dp Spacer — i.e. the tile would reserve subtitle space for nothing.
    // Defensive: whitespace-only subtitles fall in the same trap — invisible content that still reserves layout space; collapse them to null too.
    YaruListTile(
        title = { YaruText(titleText) },
        subtitle = subtitleText?.takeIf { it.isNotBlank() }?.let { { YaruText(it) } },
        leading = leading,
        trailing = trailing,
        onTap = onTap,
        enabled = enabled,
        centerTitle = centerTitle,
        contentPadding = contentPadding,
        shape = shape,
        modifier = modifier,
    )
}

/** Variant with no rounded corners — meant to be embedded in a tile list. */
@Composable
fun YaruListTileSquare(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    leading: @Composable (() -> Unit)? = null,
    subtitle: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    onTap: (() -> Unit)? = null,
    enabled: Boolean = true,
    centerTitle: Boolean = false,
    contentPadding: PaddingValues? = null,
) {
    YaruListTile(
        title = title,
        leading = leading,
        subtitle = subtitle,
        trailing = trailing,
        onTap = onTap,
        enabled = enabled,
        centerTitle = centerTitle,
        contentPadding = contentPadding,
        shape = RoundedCornerShape(0.dp),
        modifier = modifier,
    )
}

/**
 * Mirrors `color: enabled ? null : theme.disabledColor` from
 * yaru_list_tile.dart:130/137. `disabledColor` is `onSurface @ 0.38` — the
 * scale colour has to be resolved from the scheme, not from [base]: the Yaru
 * type ladder ships `Color.Unspecified` so the widgets can inherit
 * `LocalYaruContentColor`, and `Color.Unspecified.copy(alpha = ...)` yields a
 * colour in an unspecified colour space rather than a faded label.
 */
private fun disabledTextStyle(
    base: TextStyle,
    enabled: Boolean,
    scheme: YaruColorScheme,
): TextStyle =
    if (enabled) base else base.copy(color = scheme.onSurface.copy(alpha = 0.38f))

