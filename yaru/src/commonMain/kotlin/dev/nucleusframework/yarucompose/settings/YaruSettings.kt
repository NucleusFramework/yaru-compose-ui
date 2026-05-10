package dev.nucleusframework.yarucompose.settings

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Reads desktop-environment settings that influence the Yaru theme:
 * GTK theme name, GNOME accent color, accessibility status shapes.
 *
 * Mirrors `yaru.dart/lib/src/settings/yaru_settings.dart`. Host apps should
 * provide their own implementation per platform; commonMain ships
 * [NoOpYaruSettings], a stub returning `null`/empty flows.
 */
interface YaruSettings {
    fun getThemeName(): String?
    fun getAccentColor(): String?
    fun getStatusShapes(): Boolean?

    val themeNameChanged: Flow<String?>
    val accentColorChanged: Flow<String?>
    val statusShapesChanged: Flow<Boolean?>

    fun init()
    suspend fun dispose()
}

/** No-op implementation suitable for non-Linux platforms or unit tests. */
class NoOpYaruSettings : YaruSettings {
    private val empty = MutableStateFlow<String?>(null).asStateFlow()
    private val emptyBool = MutableStateFlow<Boolean?>(null).asStateFlow()

    override fun getThemeName(): String? = null
    override fun getAccentColor(): String? = null
    override fun getStatusShapes(): Boolean? = null

    override val themeNameChanged: Flow<String?> get() = empty
    override val accentColorChanged: Flow<String?> get() = empty
    override val statusShapesChanged: Flow<Boolean?> get() = emptyBool

    override fun init() = Unit
    override suspend fun dispose() = Unit
}
