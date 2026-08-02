package sample.app.pages

import androidx.compose.foundation.clickable
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import coil3.request.ImageRequest
import coil3.request.crossfade
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruCircularProgressIndicator
import dev.nucleusframework.yarucompose.widgets.YaruDialog
import dev.nucleusframework.yarucompose.widgets.YaruSearchField
import dev.nucleusframework.yarucompose.widgets.YaruTab
import dev.nucleusframework.yarucompose.widgets.YaruTabBar
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.CodeBlock

// Mirrors Dart `_urlPrefix` / `_urlSuffix` from `full_color_icons_page.dart:545-547`.
private const val IconUrlPrefix =
    "https://raw.githubusercontent.com/ubuntu/yaru/master/icons/Yaru/256x256/"
private const val IconUrlSuffix = ".png"

/**
 * Full-colour icon catalog from `yaru.dart/example/lib/pages/full_color_icons_page.dart`.
 *
 * Mirrors Flutter's `Image.network(...)` flow: each icon is fetched from
 * `raw.githubusercontent.com/ubuntu/yaru/master/icons/Yaru/256x256/<dir>/<name>.png`
 * via Coil 3 + Ktor 3. While loading, a `YaruCircularProgressIndicator` is
 * shown; on error we fall back to the monochrome `YaruIcons.question` glyph
 * (matches Dart `errorBuilder`).
 */
@Composable
fun FullColorIconsPage() {
    val categories = remember { iconDirsToIconNames.entries.toList() }
    var selectedTab by remember { mutableIntStateOf(1.coerceAtMost(categories.lastIndex)) }
    var query by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf<String?>(null) }
    val currentDir = categories[selectedTab].key

    Column(modifier = Modifier.fillMaxSize()) {
        // full_color_icons_page.dart L37-L45: `EdgeInsets.symmetric(horizontal: kYaruPagePadding)`
        // — no vertical padding on the tab bar.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = YaruConstants.PagePadding),
        ) {
            YaruTabBar(
                selectedTabIndex = selectedTab,
                onTabSelected = { selectedTab = it },
                tabs = categories.map { entry -> { YaruTab(label = entry.key) } },
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = YaruConstants.PagePadding),
        ) {
            YaruSearchField(
                value = query,
                onValueChange = { query = it },
                placeholder = "Search icons",
                autoFocus = false,
                onClear = { query = "" },
            )
        }
        val current = categories[selectedTab].value
        val filtered = remember(current, query) {
            if (query.isBlank()) current
            else current.filter { it.contains(query, ignoreCase = true) }
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 100.dp),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            items(filtered, key = { it }) { name ->
                FullColorIconCell(
                    name = name,
                    dir = currentDir,
                    onClick = { selected = name },
                )
            }
        }
    }

    selected?.let { name ->
        YaruDialog(
            onDismissRequest = { selected = null },
            title = { YaruText(name) },
            contentPadding = PaddingValues(16.dp),
        ) {
            CodeBlock(code = "AsyncImage(model = \"$IconUrlPrefix$currentDir/$name$IconUrlSuffix\")")
        }
    }
}

@Composable
private fun FullColorIconCell(name: String, dir: String, onClick: () -> Unit) {
    val shape = RoundedCornerShape(YaruConstants.ButtonRadius)
    val url = remember(name, dir) { "$IconUrlPrefix$dir/$name$IconUrlSuffix" }
    val context = LocalPlatformContext.current
    val request = remember(context, url) {
        ImageRequest.Builder(context)
            .data(url)
            .crossfade(true)
            .build()
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(shape)
            .clickable(onClick = onClick)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(modifier = Modifier.size(35.dp), contentAlignment = Alignment.Center) {
            // SubcomposeAsyncImage gives us per-state slots (Loading / Error /
            // Success) — needed to mirror Flutter's `errorBuilder` fallback to
            // the monochrome glyph and the implicit progress placeholder.
            SubcomposeAsyncImage(
                model = request,
                contentDescription = name,
                modifier = Modifier.fillMaxSize(),
                loading = { YaruCircularProgressIndicator(modifier = Modifier.size(20.dp)) },
                error = { YaruIcon(glyph = YaruIcons.question, size = 35.dp) },
                success = { SubcomposeAsyncImageContent() },
            )
        }
        Spacer(Modifier.height(6.dp))
        YaruText(
            text = name,
            style = LocalYaruTypography.current.labelSmall,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

/**
 * Mirrors `iconDirsToIconNames` from `yaru.dart/example/lib/pages/full_color_icons_page.dart`.
 * Names use the Freedesktop convention (kebab-case); they are resolved at render time.
 */
private val iconDirsToIconNames: Map<String, List<String>> = linkedMapOf(
    "actions" to listOf(
        "address-book-new", "appointment-new", "blueman-plugin", "blueman-trust", "blueman-untrust",
        "cancel", "configure", "dialog-apply", "document-new", "document-open-recent",
        "document-open", "document-page-setup", "document-print-preview", "document-print",
        "document-properties", "document-revert", "document-save-as", "document-save",
        "document-send", "edit-copy", "edit-cut", "edit-delete", "edit-find-replace",
        "edit-find", "edit-paste", "edit-redo", "edit-select-all", "edit-undo", "folder-new",
        "format-indent-less", "format-indent-more", "format-justify-center", "format-justify-fill",
        "format-justify-left", "format-justify-right", "format-text-bold", "format-text-italic",
        "format-text-strikethrough", "format-text-underline", "go-first", "go-last", "help-about",
        "help-contents", "mail-archive", "mail-forward", "mail-inbox", "mail-mark-important",
        "mail-mark-junk", "mail-mark-notjunk", "mail-message-new", "mail-outbox", "mail-read",
        "mail-reply-all", "mail-reply-sender", "mail-send-receive", "mail-send", "mail-sent",
        "mail-unread", "system-log-out", "system-reboot", "system-shutdown", "view-app-grid",
        "zoom-in", "zoom-out",
    ),
    "apps" to listOf(
        "accessories-character-map", "accessories-dictionary", "accessories-text-editor",
        "address-book-app", "app-center", "applications-multimedia", "applications-office",
        "backups-app", "bluetooth", "calculator-app", "calendar-app", "camera-app", "clock-app",
        "configurator-app", "disk-usage-app", "disk-utility-app", "documents-app", "docviewer-app",
        "ebook-reader-app", "error-app", "evince", "extensions", "file-roller", "filemanager-app",
        "gallery-app", "games-app", "gnome-aisleriot", "gnome-mahjongg", "gnome-mines", "gparted",
        "help-app", "image-viewer-app", "jockey", "libreoffice-base", "libreoffice-calc",
        "libreoffice-draw", "libreoffice-impress", "libreoffice-main", "libreoffice-math",
        "libreoffice-writer", "livepatch", "log-viewer-app", "mail-app", "maps-app",
        "mediaplayer-app", "messaging-app", "music-app", "notes-app", "nvidia-settings",
        "org.gnome.Calls", "org.gnome.Software.Create", "org.gnome.Software.Develop",
        "org.gnome.Software.Socialize", "org.gnome.Software", "org.gnome.SoundRecorder",
        "org.gnome.TextEditor", "packages-app", "passwords-app", "podcasts-app",
        "power-statistics", "quadrapassel", "rhythmbox", "root-terminal-app", "scanner",
        "screenshot-app", "session-properties", "shotwell", "snap-store", "software-properties",
        "software-store", "software-updater", "sudoku-app", "synaptic", "system-monitor-app",
        "system-settings", "terminal-app", "to-do-app", "transmission", "tweaks-app", "ubiquity",
        "usage-app", "usb-creator-gtk", "weather-app", "webbrowser-app", "wine", "winetricks",
        "workspace-switcher-left-bottom", "workspace-switcher-left-top",
        "workspace-switcher-right-bottom", "workspace-switcher-right-top",
    ),
    "categories" to listOf(
        "applications-accessories", "applications-development", "applications-games",
        "applications-graphics", "preferences-color", "preferences-desktop-accessibility",
        "preferences-desktop-display", "preferences-desktop-font",
        "preferences-desktop-keyboard-shortcuts", "preferences-desktop-locale",
        "preferences-desktop-online-accounts", "preferences-desktop-wallpaper",
        "preferences-system-bluetooth", "preferences-system-brightness-lock",
        "preferences-system-network", "preferences-system-power", "preferences-system-sharing",
        "preferences-system-sound", "preferences-system-time", "preferences-system-users",
        "system-component-addon", "system-component-application", "system-component-codecs",
        "system-component-driver", "system-component-input-sources", "system-component-os-updates",
    ),
    "devices" to listOf(
        "audio-headphones", "audio-headset", "audio-speakers", "blueman-device", "computer",
        "drive-harddisk-ieee1394", "drive-harddisk-solidstate", "drive-harddisk-usb",
        "drive-harddisk", "drive-multidisk", "drive-optical", "drive-removable-media-usb",
        "drive-removable-media", "input-gaming", "input-keyboard", "input-mouse", "media-flash",
        "media-floppy", "media-optical", "multimedia-player", "phone", "printer-network",
        "printer",
    ),
    "emblems" to listOf(
        "emblem-danger", "emblem-default", "emblem-dialog-question", "emblem-documents",
        "emblem-downloads", "emblem-dropbox-infinite", "emblem-dropbox-selsync",
        "emblem-favorite", "emblem-list-add", "emblem-people", "emblem-personal", "emblem-photos",
        "emblem-readonly", "emblem-shared", "emblem-symbolic-link", "emblem-synchronizing",
        "emblem-system", "emblem-unreadable", "emblem-urgent", "emblem-videos",
    ),
    "legacy" to listOf("document-export", "document-import", "list-add", "list-remove"),
    "mimetypes" to listOf(
        "application-apk", "application-epub+zip", "application-geo+json",
        "application-illustrator", "application-json", "application-octet-stream",
        "application-pdf", "application-pgp-encrypted", "application-pgp-keys",
        "application-pgp-signature", "application-photoshop", "application-postscript",
        "application-vnd-dart", "application-vnd.debian.binary-package",
        "application-vnd.flatpak", "application-vnd.iccprofile",
        "application-vnd.ms-access", "application-vnd.ms-excel",
        "application-vnd.ms-powerpoint", "application-vnd.ms-publisher",
        "application-vnd.ms-word", "application-vnd.openofficeorg.extension",
        "application-vnd.snap", "application-vnd.squashfs",
        "application-x-7z-compressed", "application-x-addon",
        "application-x-apple-diskimage", "application-x-audacity-project",
        "application-x-bittorrent", "application-x-cd-image", "application-x-desktop",
        "application-x-executable", "application-x-firmware", "application-x-gzip",
        "application-x-hwp", "application-x-ipynb+json", "application-x-java",
        "application-x-karbon", "application-x-krita", "application-x-lmms-project",
        "application-x-mobipocket-ebook", "application-x-model",
        "application-x-ms-dos-executable", "application-x-mswinurl",
        "application-x-musescore3", "application-x-perl", "application-x-php",
        "application-x-pkcs7-certificates", "application-x-python-bytecode",
        "application-x-qemu-disk", "application-x-rar", "application-x-raw-disk-image",
        "application-x-rss+xml", "application-x-shellscript", "application-x-subrip",
        "application-x-theme", "application-x-trash", "application-x-virtualbox-hdd",
        "application-x-virtualbox-ova", "application-x-virtualbox-ovf",
        "application-x-virtualbox-vbox-extpack", "application-x-virtualbox-vbox",
        "application-x-virtualbox-vdi", "application-x-virtualbox-vhd",
        "application-x-virtualbox-vmdk", "application-x-yaml", "application-x-zip",
        "audio-midi", "audio-x-flac", "audio-x-generic", "audio-x-mpeg",
        "audio-x-mpegurl", "audio-x-ms-wma", "audio-x-vorbis+ogg", "audio-x-wav",
        "font-x-generic", "html-template", "image-svg+xml", "image-x-cursor",
        "image-x-generic", "image-x-xcf", "inode-symlink",
        "libreoffice-oasis-database", "libreoffice-oasis-drawing",
        "libreoffice-oasis-formula", "libreoffice-oasis-master-document",
        "libreoffice-oasis-presentation", "libreoffice-oasis-spreadsheet",
        "libreoffice-oasis-text", "libreoffice-oasis-web", "message-rfc822",
        "package-x-generic", "rom", "text-css", "text-dockerfile", "text-html",
        "text-less", "text-markdown", "text-richtext", "text-rust", "text-x-arduino",
        "text-x-authors", "text-x-c++hdr", "text-x-c", "text-x-chdr", "text-x-cobol",
        "text-x-copying", "text-x-cpp", "text-x-csharp", "text-x-dart",
        "text-x-fortran", "text-x-generic", "text-x-gettext-translation-template",
        "text-x-gettext-translation", "text-x-go", "text-x-haskell", "text-x-install",
        "text-x-java", "text-x-javascript", "text-x-kotlin", "text-x-lilypond",
        "text-x-log", "text-x-lua", "text-x-makefile", "text-x-maven+xml",
        "text-x-meson", "text-x-nim", "text-x-patch", "text-x-php", "text-x-preview",
        "text-x-python", "text-x-qml", "text-x-r", "text-x-readme", "text-x-ruby",
        "text-x-sass", "text-x-scala", "text-x-script", "text-x-sql",
        "text-x-systemd-unit", "text-x-tex", "text-x-typescript", "text-x-v",
        "text-x-vala", "text-x.gcode", "text-xml", "unknown", "video-x-generic",
        "x-office-document", "x-office-presentation", "x-office-spreadsheet",
    ),
    "places" to listOf(
        "folder-documents", "folder-download", "folder-dropbox", "folder-music",
        "folder-pictures", "folder-publicshare", "folder-remote", "folder-templates",
        "folder-videos", "folder", "insync-folder", "network-server", "network-workgroup",
        "start-here", "user-desktop", "user-home", "user-trash",
    ),
    "status" to listOf(
        "appointment-soon", "aptdaemon-add", "aptdaemon-cleanup", "aptdaemon-delete",
        "aptdaemon-download", "aptdaemon-resolve", "aptdaemon-setup", "aptdaemon-update-cache",
        "aptdaemon-upgrade", "aptdaemon-wait", "aptdaemon-working", "avatar-default",
        "bluetooth-active", "bluetooth-disabled", "dialog-error", "dialog-information",
        "dialog-warning", "folder-open", "image-loading", "image-missing", "nm-device-wireless",
        "software-update-available", "user-trash-full",
    ),
)
