package dev.nucleusframework.yarucompose.widgets

/**
 * Generic interaction contract shared by toggle controls
 * (`YaruCheckbox`, `YaruRadio`, `YaruSwitch`).
 *
 * Mirrors the abstract `YaruTogglable` from
 * `yaru.dart/lib/src/widgets/yaru_togglable.dart`. In Compose the rendering
 * happens inside Material3 components — this interface only captures the
 * shared parameters so callers can write generic toggle helpers.
 */
interface YaruTogglable<T> {
    val value: T
    val checked: Boolean?
    val tristate: Boolean
    val onChanged: ((T) -> Unit)?
    val interactive: Boolean
        get() = onChanged != null
}
