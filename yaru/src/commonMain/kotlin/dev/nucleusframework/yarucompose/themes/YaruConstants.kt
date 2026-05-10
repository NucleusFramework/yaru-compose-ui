package dev.nucleusframework.yarucompose.themes

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Public constants ported from `yaru.dart/lib/constants.dart`.
 *
 * Names use the Kotlin `Yaru*` style (no `k` prefix) to match `androidx.compose`
 * conventions while keeping the original semantics.
 */
object YaruConstants {
    /** Recommended padding around page content in Yaru applications. */
    val PagePadding: Dp = 20.dp

    /** Default height of `YaruTitleBar`. */
    val TitleBarHeight: Dp = 46.dp

    /** Default border radius for Yaru-style containers. */
    val ContainerRadius: Dp = 12.dp

    /** Default border radius for Yaru-style buttons. */
    val ButtonRadius: Dp = 8.dp

    /** Default border radius for Yaru-style checkboxes. */
    val CheckRadius: Dp = 4.dp

    /** Default border radius for window-shaped surfaces. */
    val WindowRadius: Dp = 14.dp

    /** Default elevation for Yaru AppBars (flat). */
    const val AppBarElevation: Float = 0f

    val AppBarHeight: Dp = 46.dp
    val NavigationBarHeight: Dp = 64.dp
    val ButtonHeight: Dp = 34.dp

    /** Default breakpoint between portrait and landscape `YaruMasterDetailPage`. */
    val MasterDetailBreakpoint: Dp = 620.dp

    /** Best height for any item inside a `YaruTitleBar`. */
    val TitleBarItemHeight: Dp = 34.dp

    /** Default icon size. */
    val IconSize: Dp = 20.dp

    /** Default focus border width for various Yaru widgets. */
    val FocusBorderWidth: Dp = 2.dp

    /** `_kCheckboxTogglableSize` from `yaru_checkbox.dart`. */
    val CheckboxTogglableSize: Dp = 20.dp

    /** `_kCheckboxActivableAreaPadding` from `yaru_checkbox.dart`. */
    val CheckboxActivableAreaPadding: Dp = 6.dp

    /** `_kRadioTogglableSize` from `yaru_radio.dart`. */
    val RadioTogglableSize: Dp = 20.dp

    /** `_kRadioActivableAreaPadding` from `yaru_radio.dart`. */
    val RadioActivableAreaPadding: Dp = 6.dp

    /** `_kSwitchSize` from `yaru_switch.dart`. */
    val SwitchWidth: Dp = 48.dp

    /** `_kSwitchSize.height` from `yaru_switch.dart`. */
    val SwitchHeight: Dp = 26.dp

    /** `_kSwitchThumbSizeFactor` from `yaru_switch.dart`. */
    const val SwitchThumbSizeFactor: Float = 0.76f
}
