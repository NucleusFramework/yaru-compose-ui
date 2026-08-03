package sample.app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import dev.nucleusframework.yarucompose.foundation.YaruPageController
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.YaruTheme
import dev.nucleusframework.yarucompose.themes.YaruVariant
import dev.nucleusframework.yarucompose.window.LocalWindowLayoutDirectionSync
import dev.nucleusframework.yarucompose.themes.yaruSystemAccentVariant
import dev.nucleusframework.yarucompose.themes.yaruSystemInDarkMode
import dev.nucleusframework.yarucompose.themes.isHighContrast
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.themes.scale
import dev.nucleusframework.yarucompose.widgets.YaruButtonVariant
import dev.nucleusframework.yarucompose.widgets.YaruColorDisk
import dev.nucleusframework.yarucompose.widgets.YaruIconButton
import dev.nucleusframework.yarucompose.widgets.YaruListTile
import dev.nucleusframework.yarucompose.widgets.YaruOutlinedButton
import dev.nucleusframework.yarucompose.widgets.YaruPopupMenuButton
import dev.nucleusframework.yarucompose.widgets.YaruPopupMenuEntry
import dev.nucleusframework.yarucompose.widgets.YaruResizablePaneDelegate
import dev.nucleusframework.yarucompose.widgets.YaruSwitch
import dev.nucleusframework.yarucompose.widgets.YaruDialogTitleBar
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTitleBar
import dev.nucleusframework.yarucompose.widgets.YaruTitleBarStyle
import dev.nucleusframework.yarucompose.widgets.master_detail.YaruDetailPage
import dev.nucleusframework.yarucompose.widgets.master_detail.YaruMasterDetailPage
import dev.nucleusframework.yarucompose.widgets.master_detail.YaruMasterTile
import dev.nucleusframework.yarucompose.widgets.navi_rail.YaruNavigationPage
import dev.nucleusframework.yarucompose.widgets.navi_rail.YaruNavigationRailItem
import dev.nucleusframework.yarucompose.widgets.navi_rail.YaruNavigationRailStyle
import sample.app.pages.AutocompletePage
import sample.app.pages.BannerPage
import sample.app.pages.BorderContainerPage
import sample.app.pages.CarouselPage
import sample.app.pages.CheckboxPage
import sample.app.pages.ChoiceChipBarPage
import sample.app.pages.ClipPage
import sample.app.pages.ColorDiskPage
import sample.app.pages.ContextMenuPage
import sample.app.pages.DateTimeEntryPage
import sample.app.pages.DialogPage
import sample.app.pages.DraggablePage
import sample.app.pages.ExpandablePage
import sample.app.pages.ExpansionPanelPage
import sample.app.pages.FullColorIconsPage
import sample.app.pages.HomePage
import sample.app.pages.IconButtonPage
import sample.app.pages.IconsPage
import sample.app.pages.InfoPage
import sample.app.pages.LicensePage
import sample.app.pages.ListTilePage
import sample.app.pages.NavigationPage
import sample.app.pages.OptionButtonPage
import sample.app.pages.PageIndicatorPage
import sample.app.pages.PanedViewPage
import sample.app.pages.PopupPage
import sample.app.pages.ProgressIndicatorPage
import sample.app.pages.RadioPage
import sample.app.pages.SearchFieldPage
import sample.app.pages.SectionPage
import sample.app.pages.SelectableContainerPage
import sample.app.pages.SplitButtonPage
import sample.app.pages.SwitchPage
import sample.app.pages.TabBarPage
import sample.app.pages.TilePage

/**
 * One entry in the master list, mirroring `PageItem` from
 * `yaru.dart/example/lib/example_page_items.dart` (lines 41-61).
 *
 * `titleBuilder` / `actionsBuilder` / `floatingActionButtonContent` mirror the
 * Dart per-page hooks consumed by `_MasterDetailPage.pageBuilder` (example.dart
 * lines 52-66).
 */
private data class SamplePage(
    val title: String,
    val iconGlyph: Char,
    val selectedIconGlyph: Char = iconGlyph,
    val titleContent: (@Composable () -> Unit)? = null,
    val actionsContent: (@Composable () -> Unit)? = null,
    val floatingActionButtonContent: (@Composable () -> Unit)? = null,
    val content: @Composable () -> Unit,
)

/**
 * Landing + reference entries, mirroring the `GENERAL` group of the
 * compose-macos-26-ui sample: they lead the master list and the widget pages
 * follow alphabetically.
 */
private val OverviewPages: List<SamplePage> = listOf(
    SamplePage(
        title = "Home",
        iconGlyph = YaruIcons.home,
        selectedIconGlyph = YaruIcons.home_filled,
        titleContent = { YaruText("YaruCompose") },
    ) {
        val navigate = LocalSampleNavigator.current
        HomePage(
            widgetCount = WidgetPages.size,
            onExploreWidgets = { navigate(FirstWidgetPageIndex) },
        )
    },
    SamplePage(
        title = "License",
        iconGlyph = YaruIcons.document,
        selectedIconGlyph = YaruIcons.document_filled,
    ) { LicensePage() },
)

/**
 * Widget page list mirrors `examplePageItems` in `example_page_items.dart`
 * (lines 63-397). Dart sorts the list with `.sortedBy((p) => p.title)`, so the
 * order below is alphabetical by `title`. Icons match the Dart `iconBuilder`
 * mappings line by line.
 */
private val WidgetPages: List<SamplePage> = listOf(
    // example_page_items.dart:64-72.
    SamplePage(
        title = "YaruAutocomplete",
        iconGlyph = YaruIcons.question,
    ) { AutocompletePage() },
    // example_page_items.dart:73-83.
    SamplePage(
        title = "YaruBanner",
        iconGlyph = YaruIcons.image,
        selectedIconGlyph = YaruIcons.image_filled,
    ) { BannerPage() },
    // example_page_items.dart:375-387.
    SamplePage(
        title = "YaruBorderContainer",
        iconGlyph = YaruIcons.cloud,
        selectedIconGlyph = YaruIcons.cloud_filled,
    ) { BorderContainerPage() },
    // example_page_items.dart:84-92.
    SamplePage(
        title = "YaruCarousel",
        iconGlyph = YaruIcons.refresh,
    ) { CarouselPage() },
    // example_page_items.dart:93-103.
    SamplePage(
        title = "YaruCheckbox",
        iconGlyph = YaruIcons.checkbox_checked,
        selectedIconGlyph = YaruIcons.checkbox_checked_filled,
    ) { CheckboxPage() },
    // example_page_items.dart:104-112.
    SamplePage(
        title = "YaruChoiceChipBar",
        iconGlyph = YaruIcons.paper_clip,
    ) { ChoiceChipBarPage() },
    // example_page_items.dart:113-126 — Dart applies a horizontal flip via
    // `Transform.scale(scaleX: -1)`, omitted here.
    SamplePage(
        title = "YaruClip",
        iconGlyph = YaruIcons.network_cellular_signal_none,
        selectedIconGlyph = YaruIcons.network_cellular_signal_excellent,
    ) { ClipPage() },
    // example_page_items.dart:127-135.
    SamplePage(
        title = "YaruColorDisk",
        iconGlyph = YaruIcons.color_select,
    ) { ColorDiskPage() },
    // No Dart counterpart — GTK apps get their context menus from the toolkit.
    SamplePage(
        title = "YaruContextMenu",
        iconGlyph = YaruIcons.view_more,
    ) { ContextMenuPage() },
    // example_page_items.dart:136-146.
    SamplePage(
        title = "YaruDateTimeEntry",
        iconGlyph = YaruIcons.calendar_month,
        selectedIconGlyph = YaruIcons.calendar_month_filled,
    ) { DateTimeEntryPage() },
    // example_page_items.dart:316-326 — Dart titles this "YaruDialogTitleBar".
    SamplePage(
        title = "YaruDialogTitleBar",
        iconGlyph = YaruIcons.information,
        selectedIconGlyph = YaruIcons.information_filled,
    ) { DialogPage() },
    // example_page_items.dart:147-155.
    SamplePage(
        title = "YaruDraggable",
        iconGlyph = YaruIcons.drag_handle,
    ) { DraggablePage() },
    // example_page_items.dart:156-164.
    SamplePage(
        title = "YaruExpandable",
        iconGlyph = YaruIcons.pan_down,
    ) { ExpandablePage() },
    // example_page_items.dart:165-173.
    SamplePage(
        title = "YaruExpansionPanel",
        iconGlyph = YaruIcons.ordered_list_new,
    ) { ExpansionPanelPage() },
    // example_page_items.dart:174-182.
    SamplePage(
        title = "YaruIconButton",
        iconGlyph = YaruIcons.app_grid,
    ) { IconButtonPage() },
    // example_page_items.dart:327-344 — Dart's `YaruIcons` page uses a custom
    // titleBuilder + actions; for parity we use the same icon glyphs.
    SamplePage(
        title = "YaruIcons",
        iconGlyph = YaruIcons.placeholder_icon,
        selectedIconGlyph = YaruIcons.placeholder_icon_filled,
    ) { IconsPage() },
    // example_page_items.dart:345-354 — titleBuilder = "Full Color Free Desktop Yaru Icons".
    SamplePage(
        title = "YaruIcons, FullColor",
        iconGlyph = YaruIcons.ubuntu_logo_simple,
        selectedIconGlyph = YaruIcons.ubuntu_logo_simple,
        titleContent = { YaruText("Full Color Free Desktop Yaru Icons") },
    ) { FullColorIconsPage() },
    // example_page_items.dart:362-374.
    SamplePage(
        title = "YaruInfo",
        iconGlyph = YaruIcons.information,
        selectedIconGlyph = YaruIcons.information_filled,
    ) { InfoPage() },
    // example_page_items.dart:311-315.
    SamplePage(
        title = "YaruListTile",
        iconGlyph = YaruIcons.unordered_list,
    ) { ListTilePage() },
    // example_page_items.dart:183-190 — Dart restricts this entry to
    // `YaruMasterDetailPage` only; the Compose port has no compact mode yet
    // so it always renders.
    SamplePage(
        title = "YaruNavigationPage",
        iconGlyph = YaruIcons.compass,
        selectedIconGlyph = YaruIcons.compass_filled,
    ) { NavigationPage() },
    // example_page_items.dart:191-201.
    SamplePage(
        title = "YaruOptionButton",
        iconGlyph = YaruIcons.gear,
        selectedIconGlyph = YaruIcons.gear_filled,
    ) { OptionButtonPage() },
    // example_page_items.dart:202-211.
    SamplePage(
        title = "YaruPageIndicator",
        iconGlyph = YaruIcons.view_more_horizontal,
    ) { PageIndicatorPage() },
    // example_page_items.dart:212-219.
    SamplePage(
        title = "YaruPanedView",
        iconGlyph = YaruIcons.sidebar,
        selectedIconGlyph = YaruIcons.sidebar_filled,
    ) { PanedViewPage() },
    // example_page_items.dart:220-228.
    SamplePage(
        title = "YaruPopupMenuButton",
        iconGlyph = YaruIcons.stop,
    ) { PopupPage() },
    // example_page_items.dart:229-239.
    SamplePage(
        title = "YaruProgressIndicator",
        iconGlyph = YaruIcons.download,
        selectedIconGlyph = YaruIcons.download_filled,
    ) { ProgressIndicatorPage() },
    // example_page_items.dart:240-250.
    SamplePage(
        title = "YaruRadio",
        iconGlyph = YaruIcons.radiobox_checked,
        selectedIconGlyph = YaruIcons.radiobox_checked_filled,
    ) { RadioPage() },
    // example_page_items.dart:251-261.
    SamplePage(
        title = "YaruSearchField",
        iconGlyph = YaruIcons.search,
        selectedIconGlyph = YaruIcons.search_filled,
    ) { SearchFieldPage() },
    // example_page_items.dart:262-272.
    SamplePage(
        title = "YaruSection",
        iconGlyph = YaruIcons.window,
        selectedIconGlyph = YaruIcons.window_filled,
    ) { SectionPage() },
    // example_page_items.dart:273-281.
    SamplePage(
        title = "YaruSelectableContainer",
        iconGlyph = YaruIcons.selection,
    ) { SelectableContainerPage() },
    // example_page_items.dart:388-396.
    SamplePage(
        title = "YaruSplitButton",
        iconGlyph = YaruIcons.pan_down,
    ) { SplitButtonPage() },
    // example_page_items.dart:282-292.
    SamplePage(
        title = "YaruSwitch",
        iconGlyph = YaruIcons.switchbox,
        selectedIconGlyph = YaruIcons.switchbox_checked_filled,
    ) { SwitchPage() },
    // example_page_items.dart:293-301.
    SamplePage(
        title = "YaruTabBar",
        iconGlyph = YaruIcons.tab_new,
    ) { TabBarPage() },
    // example_page_items.dart:302-310.
    SamplePage(
        title = "YaruTile",
        iconGlyph = YaruIcons.unordered_list,
    ) { TilePage() },
).sortedBy { it.title }

private val SamplePages: List<SamplePage> = OverviewPages + WidgetPages

/** Index of the first widget page — [OverviewPages] leads the master list. */
private val FirstWidgetPageIndex: Int = OverviewPages.size

/** Lets the home page hand the selection over to a widget page. */
private val LocalSampleNavigator = staticCompositionLocalOf<(Int) -> Unit> { {} }

/**
 * Three-state theme mode mirrors Dart's `ThemeMode` (system / light / dark)
 * cycled by `ExampleDarkLightToggleButton` (example_dark_light_toggle_button.dart
 * lines 16-26).
 */
private enum class ThemeModeChoice { System, Light, Dark }

/**
 * Mirrors `ExampleModel` from yaru.dart's example app
 * (example_model.dart lines 9-94): runtime theming knobs that the title-bar
 * buttons + Settings dialog mutate.
 */
private class ExampleSettings(
    val themeMode: MutableState<ThemeModeChoice>,
    /** `null` follows the desktop accent — the "System" row of the picker. */
    val variant: MutableState<YaruVariant?>,
    val highContrast: MutableState<Boolean>,
    val compactMode: MutableState<Boolean>,
    val rtl: MutableState<Boolean>,
)

@Composable
private fun rememberExampleSettings(): ExampleSettings {
    return remember {
        ExampleSettings(
            themeMode = mutableStateOf(ThemeModeChoice.System),
            // Follow the desktop accent by default, like GNOME's own apps —
            // the picker's "System" row comes back to it.
            variant = mutableStateOf(null),
            highContrast = mutableStateOf(false),
            compactMode = mutableStateOf(false),
            rtl = mutableStateOf(false),
        )
    }
}

@Composable
fun App() {
    val settings = rememberExampleSettings()
    // Mirrors Dart `ThemeMode.system` resolving against platform brightness
    // via `MediaQuery.platformBrightness` (example.dart:19-25). Compose's own
    // `isSystemInDarkTheme()` is blind to the desktop setting, so this goes
    // through Yaru, which reads it natively there.
    val systemDark = yaruSystemInDarkMode()
    // `null` variant = follow the desktop accent; Orange is Ubuntu's fallback
    // where the platform exposes none.
    val systemVariant = yaruSystemAccentVariant() ?: YaruVariant.Orange
    val variant = settings.variant.value ?: systemVariant
    val isDark = when (settings.themeMode.value) {
        ThemeModeChoice.System -> systemDark
        ThemeModeChoice.Light -> false
        ThemeModeChoice.Dark -> true
    }

    YaruTheme(
        isDark = isDark,
        highContrast = settings.highContrast.value,
        variant = variant,
    ) {
        // RTL is propagated via LocalLayoutDirection so every descendant
        // (including positioning of master/detail panes) flips together —
        // mirrors example.dart:19-25 `Directionality(textDirection: …)`.
        val layoutDirection =
            if (settings.rtl.value) LayoutDirection.Rtl else LayoutDirection.Ltr
        // The window controls are composed above this content, so they cannot
        // see the direction provided below — report it (no-op without a
        // windowing layer).
        val windowDirectionSync = LocalWindowLayoutDirectionSync.current
        LaunchedEffect(windowDirectionSync, layoutDirection) {
            windowDirectionSync?.invoke(layoutDirection)
        }
        CompositionLocalProvider(
            LocalLayoutDirection provides layoutDirection,
            // A native dialog composes in its own window: it cannot inherit the
            // theme through the locals, so hand it the arguments to rebuild it.
            LocalSampleThemeSpec provides SampleThemeSpec(
                isDark = isDark,
                highContrast = settings.highContrast.value,
                variant = variant,
            ),
        ) {
            ExampleHome(settings = settings)
        }
    }
}

@Composable
private fun ExampleHome(settings: ExampleSettings) {
    var settingsOpen by remember { mutableStateOf(false) }
    // A single controller owns the selection for both shells, so toggling
    // compact mode keeps the page you were on — and the home page can push a
    // selection through `LocalSampleNavigator`.
    val controller = remember { YaruPageController(length = SamplePages.size) }
    val navigate = remember(controller) { { index: Int -> controller.index = index } }

    CompositionLocalProvider(LocalSampleNavigator provides navigate) {
        if (settings.compactMode.value) {
            CompactShell(controller = controller, onOpenSettings = { settingsOpen = true })
        } else {
            MasterDetailShell(
                settings = settings,
                controller = controller,
                onOpenSettings = { settingsOpen = true },
            )
        }
    }

    if (settingsOpen) {
        SettingsDialog(
            settings = settings,
            onDismiss = { settingsOpen = false },
        )
    }
}

/**
 * Compact layout — mirrors Dart's `_CompactPage` (example.dart:93-160): a top
 * `YaruWindowTitleBar` over a `YaruNavigationPage` whose rail style adapts to
 * the available width (compact / labelled / labelledExtended).
 */
@Composable
private fun CompactShell(
    controller: YaruPageController,
    onOpenSettings: () -> Unit,
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val railStyle = when {
            maxWidth > 1000.dp -> YaruNavigationRailStyle.LabelledExtended
            maxWidth > 500.dp -> YaruNavigationRailStyle.Labelled
            else -> YaruNavigationRailStyle.Compact
        }
        // The controller starts unselected (`-1`); the rail coerces the same way.
        val activeItem = SamplePages[controller.index.coerceIn(0, SamplePages.size - 1)]
        Column(modifier = Modifier.fillMaxSize()) {
            // Mirrors Dart `Scaffold.appBar: YaruWindowTitleBar` (example.dart:120-131).
            YaruTitleBar(
                title = { (activeItem.titleContent ?: { YaruText(activeItem.title) })() },
                actions = activeItem.actionsContent,
                style = YaruTitleBarStyle.Normal,
            )
            Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
                YaruNavigationPage(
                    length = SamplePages.size,
                    controller = controller,
                    itemBuilder = { index, selected, onTap ->
                        val item = SamplePages[index]
                        YaruNavigationRailItem(
                            icon = { YaruIcon(if (selected) item.selectedIconGlyph else item.iconGlyph) },
                            label = { YaruText(item.title) },
                            selected = selected,
                            onTap = onTap,
                            style = railStyle,
                        )
                    },
                    pageBuilder = { index ->
                        val item = SamplePages[index]
                        YaruDetailPage(
                            floatingActionButton = item.floatingActionButtonContent,
                            body = { item.content() },
                        )
                    },
                    trailing = {
                        YaruNavigationRailItem(
                            icon = { YaruIcon(YaruIcons.gear) },
                            label = { YaruText("Settings") },
                            selected = false,
                            onTap = onOpenSettings,
                            style = railStyle,
                        )
                    },
                )
            }
        }
    }
}

@Composable
private fun MasterDetailShell(
    settings: ExampleSettings,
    controller: YaruPageController,
    onOpenSettings: () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    // Mirrors `YaruMasterDetailThemeData.fallback.sideBarColor`.
    val sideBarColor = remember(scheme) {
        scheme.surface.scale(lightness = if (scheme.isLight) -0.029f else 0.029f)
    }

    YaruMasterDetailPage(
        length = SamplePages.size,
        controller = controller,
        // example.dart:41-45 — `YaruResizablePaneDelegate(initialPaneSize: 280,
        // minPageSize: kYaruMasterDetailBreakpoint / 2 (= 310), minPaneSize: 175)`.
        paneLayoutDelegate = YaruResizablePaneDelegate(
            initialPaneSize = 280.dp,
            minPaneSize = 175.dp,
            minPageSize = YaruConstants.MasterDetailBreakpoint / 2,
        ),
        appBar = {
            // example.dart:67-80 — master appBar with sideBarColor background,
            // borderless, four icon actions wrapped in 5-dp spacers.
            YaruTitleBar(
                title = { YaruText("Yaru") },
                backgroundColor = sideBarColor,
                style = YaruTitleBarStyle.Undecorated,
                actions = { TitleBarActions(settings) },
            )
        },
        tileBuilder = { index, selected, onTap ->
            val item = SamplePages[index]
            YaruMasterTile(
                leading = {
                    YaruIcon(if (selected) item.selectedIconGlyph else item.iconGlyph)
                },
                title = { YaruText(item.title) },
                // Dart gives the first tile a `Subtitle` placeholder
                // (example.dart:50); here the list opens on the home entry, so
                // the placeholder is dropped.
                selected = selected,
                onTap = onTap,
            )
        },
        pageBuilder = { index ->
            val item = SamplePages[index]
            // example.dart:52-66 — per-page detail page wires titleBuilder,
            // actionsBuilder, and floatingActionButtonBuilder. We omit the
            // `leading: YaruBackButton` because the Compose master/detail
            // landscape layout never pushes a back-stackable route.
            YaruDetailPage(
                appBar = {
                    YaruTitleBar(
                        title = { (item.titleContent ?: { YaruText(item.title) })() },
                        actions = item.actionsContent,
                        style = YaruTitleBarStyle.Undecorated,
                    )
                },
                floatingActionButton = item.floatingActionButtonContent,
                body = { item.content() },
            )
        },
        bottomBar = {
            // example.dart:81-88 — bottom bar Settings tile.
            Box(modifier = Modifier.padding(vertical = 8.dp)) {
                YaruMasterTile(
                    leading = { YaruIcon(YaruIcons.gear) },
                    title = { YaruText("Settings") },
                    selected = false,
                    onTap = onOpenSettings,
                )
            }
        },
    )
}

/**
 * Master-bar action row — mirrors example.dart:71-79: 4 icon buttons separated
 * by 5-dp horizontal spacers (with leading + trailing 5-dp gutters).
 */
@Composable
private fun TitleBarActions(settings: ExampleSettings) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Spacer(Modifier.width(5.dp))
        DarkLightToggleButton(settings)
        Spacer(Modifier.width(5.dp))
        VariantPicker(settings)
        Spacer(Modifier.width(5.dp))
        HighContrastButton(settings)
        Spacer(Modifier.width(5.dp))
    }
}

/**
 * Mirrors `ExampleDarkLightToggleButton`
 * (example_dark_light_toggle_button.dart): cycles
 * System → Light → Dark → System and shows `private_mask` / `sun` /
 * `clear_night` for each state.
 */
@Composable
private fun DarkLightToggleButton(settings: ExampleSettings) {
    YaruIconButton(
        tooltip = "ThemeMode (System, Light, Dark)",
        onPressed = {
            settings.themeMode.value = when (settings.themeMode.value) {
                ThemeModeChoice.System -> ThemeModeChoice.Light
                ThemeModeChoice.Light -> ThemeModeChoice.Dark
                ThemeModeChoice.Dark -> ThemeModeChoice.System
            }
        },
        icon = {
            YaruIcon(
                when (settings.themeMode.value) {
                    ThemeModeChoice.System -> YaruIcons.private_mask
                    ThemeModeChoice.Light -> YaruIcons.sun
                    ThemeModeChoice.Dark -> YaruIcons.clear_night
                },
            )
        },
    )
}

/**
 * Mirrors `ExampleHighContrastButton`
 * (example_high_contrast_button.dart): toggles `forceHighContrast` and
 * shows `eye` / `eye_filled`.
 */
@Composable
private fun HighContrastButton(settings: ExampleSettings) {
    YaruIconButton(
        tooltip = "Force HighContrast mode",
        onPressed = { settings.highContrast.value = !settings.highContrast.value },
        icon = {
            YaruIcon(
                if (settings.highContrast.value) YaruIcons.eye_filled else YaruIcons.eye,
            )
        },
    )
}

/**
 * Mirrors `ExampleYaruVariantPicker` (example_theme_button.dart): popup of
 * ColorDisk + variant name rows, triggered by a `color_select` icon.
 */
@Composable
private fun VariantPicker(settings: ExampleSettings) {
    // Mirrors Dart's `ExampleYaruVariantPicker` (example_theme_button.dart:24-40):
    //  - `PopupMenuItem.onTap` writes the variant on the model.
    //  - The inner `ColorDisk` is rendered without `onPressed`, so the row tap
    //    drives both selection and popup dismissal — no nested click handler.
    //  - Dart's trigger is `PopupMenuButton.icon`, a bare icon tinted with the
    //    primary color: no button border.
    // Divergence: a leading "System" row, absent from the Dart example, so the
    // picker can hand the accent back to the desktop after an explicit choice.
    val selectedVariant = settings.variant.value
    val systemVariant = yaruSystemAccentVariant() ?: YaruVariant.Orange
    val items = buildList {
        add(
            YaruPopupMenuEntry<YaruVariant?>(
                value = null,
                label = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        YaruColorDisk(
                            color = systemVariant.color,
                            selected = selectedVariant == null,
                            onPressed = null,
                        )
                        YaruText("System")
                    }
                },
            ),
        )
        YaruVariant.Accents.forEach { variant ->
            add(
                YaruPopupMenuEntry<YaruVariant?>(
                    value = variant,
                    label = {
                        // example_theme_button.dart L29-L37: Row holds [ColorDisk, Text] with no
                        // separator — the disk's built-in 8.dp padding (color_disk.dart L20) is
                        // the only gap between the disk and the label.
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            YaruColorDisk(
                                color = variant.color,
                                selected = variant == selectedVariant,
                                onPressed = null,
                            )
                            YaruText(variant.name)
                        }
                    },
                ),
            )
        }
    }
    YaruPopupMenuButton(
        items = items,
        onSelected = { settings.variant.value = it },
        showArrow = false,
        variant = YaruButtonVariant.Text,
        // The `Text` variant already tints its content with `scheme.primary`,
        // matching Dart's explicit `color: Theme.of(context).primaryColor`.
        label = { YaruIcon(YaruIcons.color_select) },
    )
}

/**
 * Settings dialog mirrors `SettingsDialog` from example.dart (lines 182-220):
 * a `YaruDialogTitleBar` over a `Column` of `YaruListTile` toggles for
 * `compactMode` and `rtl`, with an outlined `Close` button.
 *
 * On the desktop it is hosted in a real `YaruDecoratedDialog` — a native child
 * window whose close button comes from the windowing layer. Elsewhere it falls
 * back to a Compose `Dialog` with a `YaruDialogTitleBar`.
 */
@Composable
private fun SettingsDialog(
    settings: ExampleSettings,
    onDismiss: () -> Unit,
) {
    val nativeHost = LocalNativeDialogHost.current
    if (nativeHost != null) {
        val themeSpec = LocalSampleThemeSpec.current
        nativeHost.Dialog(title = "Settings", onCloseRequest = onDismiss) {
            YaruTheme(
                isDark = themeSpec.isDark,
                highContrast = themeSpec.highContrast,
                variant = themeSpec.variant,
            ) {
                // No `Close` action here: the window chrome already carries the
                // native close button, so repeating it as a button would give
                // the dialog two of them.
                SettingsDialogBody(settings = settings, onDismiss = onDismiss, showCloseAction = false)
            }
        }
        return
    }
    val scheme = LocalYaruColorScheme.current
    val shape = RoundedCornerShape(YaruConstants.WindowRadius)
    // Mirrors Dart's `_createDialogTheme` (common_themes.dart:315-330): the
    // dialog only paints a border in dark mode (white @0.2 alpha, or 1.0 in
    // high contrast). Light theme uses `BorderSide.none`.
    val borderModifier = if (scheme.isLight) {
        Modifier
    } else {
        Modifier.border(
            width = 1.dp,
            color = Color.White.copy(alpha = if (scheme.isHighContrast) 1f else 0.2f),
            shape = shape,
        )
    }
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
    ) {
        Box(
            modifier = Modifier
                .width(420.dp)
                .background(color = scheme.surface, shape = shape)
                .then(borderModifier),
        ) {
            Column {
                // Mirrors Dart's `AlertDialog.title: YaruDialogTitleBar(title: Text('Settings'))`
                // (example.dart:190): close-only title bar — the outlined `Close`
                // button below mirrors `actions: [OutlinedButton]` (example.dart:212-217).
                YaruDialogTitleBar(
                    title = { YaruText("Settings") },
                    onClose = onDismiss,
                )
                SettingsDialogBody(settings = settings, onDismiss = onDismiss)
            }
        }
    }
}

/**
 * Everything under the dialog's title bar, shared by both hosts.
 *
 * [showCloseAction] mirrors `actions: [OutlinedButton]` from example.dart:212-217;
 * a native dialog turns it off since its chrome already closes the window.
 */
@Composable
private fun SettingsDialogBody(
    settings: ExampleSettings,
    onDismiss: () -> Unit,
    showCloseAction: Boolean = true,
) {
    Column(modifier = Modifier.padding(YaruConstants.PagePadding)) {
        // example.dart:196-202. Dart switches to a `YaruNavigationPage`
        // layout (`_CompactPage`, example.dart:93-160) when compactMode
        // is on. ExampleHome reads this state and swaps the master/detail
        // shell for `YaruNavigationPage` at the top of its body.
        YaruListTile(
            title = { YaruText("Compact mode") },
            trailing = {
                YaruSwitch(
                    checked = settings.compactMode.value,
                    onCheckedChange = { settings.compactMode.value = it },
                )
            },
        )
        // example.dart:203-209.
        YaruListTile(
            title = { YaruText("RTL mode") },
            trailing = {
                YaruSwitch(
                    checked = settings.rtl.value,
                    onCheckedChange = { settings.rtl.value = it },
                )
            },
        )
    }
    // example.dart:212-217 — outlined `Close` button row.
    if (showCloseAction) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            contentAlignment = Alignment.CenterEnd,
        ) {
            Row(horizontalArrangement = Arrangement.End) {
                YaruOutlinedButton(onClick = onDismiss) { YaruText("Close") }
            }
        }
    }
}
