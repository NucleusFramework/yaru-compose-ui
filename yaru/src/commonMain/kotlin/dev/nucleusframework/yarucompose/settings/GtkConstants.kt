package dev.nucleusframework.yarucompose.settings

/**
 * GSettings schema and key identifiers used by the Yaru integration.
 *
 * Mirrors `yaru.dart/lib/src/settings/gtk_constants.dart`. These are only
 * meaningful on Linux/GNOME — they are exposed in commonMain so platform
 * implementations of [YaruSettings] can share the constants.
 */
object GtkConstants {
    const val SchemaInterface: String = "org.gnome.desktop.interface"
    const val AccentColorKey: String = "accent-color"
    const val A11ySchemaInterface: String = "org.gnome.desktop.a11y.interface"
    const val StatusShapesKey: String = "show-status-shapes"

    // GTK theme name property name (Flutter uses `kGtkThemeName`).
    const val GtkThemeName: String = "gtk-theme-name"
}
