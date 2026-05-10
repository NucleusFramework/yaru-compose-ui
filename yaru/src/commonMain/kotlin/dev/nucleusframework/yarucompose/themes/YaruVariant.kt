package dev.nucleusframework.yarucompose.themes

import androidx.compose.ui.graphics.Color

/**
 * Describes a Yaru variant and its primary color.
 *
 * Mirrors `yaru.dart/lib/src/themes/variant.dart`. The matching `ColorScheme`
 * for a variant is provided by `YaruTheme` (see `themes/YaruTheme.kt`).
 */
enum class YaruVariant(val color: Color) {
    Orange(YaruColors.Orange),
    Bark(YaruColors.Bark),
    Sage(YaruColors.Sage),
    Olive(YaruColors.Olive),
    Viridian(YaruColors.Viridian),
    PrussianGreen(YaruColors.PrussianGreen),
    Blue(YaruColors.Blue),
    Purple(YaruColors.Purple),
    Magenta(YaruColors.Magenta),
    Red(YaruColors.Red),
    WartyBrown(YaruColors.WartyBrown),
    AdwaitaBlue(YaruColors.AdwaitaBlue),
    AdwaitaTeal(YaruColors.AdwaitaTeal),
    AdwaitaGreen(YaruColors.AdwaitaGreen),
    AdwaitaYellow(YaruColors.AdwaitaYellow),
    AdwaitaOrange(YaruColors.AdwaitaOrange),
    AdwaitaRed(YaruColors.AdwaitaRed),
    AdwaitaPink(YaruColors.AdwaitaPink),
    AdwaitaPurple(YaruColors.AdwaitaPurple),
    AdwaitaSlate(YaruColors.AdwaitaSlate),
    KubuntuBlue(YaruColors.KubuntuBlue),
    LubuntuBlue(YaruColors.LubuntuBlue),
    UbuntuBudgieBlue(YaruColors.UbuntuBudgieBlue),
    UbuntuButterflyPink(YaruColors.UbuntuButterflyPink),
    UbuntuCinnamonBrown(YaruColors.UbuntuCinnamonBrown),
    UbuntuMateGreen(YaruColors.UbuntuMateGreen),
    UbuntuStudioBlue(YaruColors.UbuntuStudioBlue),
    UbuntuUnityPurple(YaruColors.UbuntuUnityPurple),
    XubuntuBlue(YaruColors.XubuntuBlue);

    companion object {
        /** The available accent color variants excluding Ubuntu flavors. */
        val Accents: List<YaruVariant> = listOf(
            Orange, Bark, Sage, Olive, Viridian, PrussianGreen, Blue, Purple,
            Magenta, Red, WartyBrown,
            AdwaitaBlue, AdwaitaTeal, AdwaitaGreen, AdwaitaYellow,
            AdwaitaOrange, AdwaitaRed, AdwaitaPink, AdwaitaPurple, AdwaitaSlate,
        )
    }
}
