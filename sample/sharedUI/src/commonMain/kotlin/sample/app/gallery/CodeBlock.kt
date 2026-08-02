package sample.app.gallery

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.themes.success
import dev.nucleusframework.yarucompose.widgets.YaruIconButton
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.snipme.highlights.Highlights
import dev.snipme.highlights.model.BoldHighlight
import dev.snipme.highlights.model.ColorHighlight
import dev.snipme.highlights.model.SyntaxLanguage
import dev.snipme.highlights.model.SyntaxThemes
import kotlinx.coroutines.delay

private const val CopiedFeedbackMillis = 2000L

/**
 * A read-only, syntax-highlighted Kotlin snippet with a copy-to-clipboard
 * affordance.
 */
@Composable
fun CodeBlock(code: String) {
    // `LocalClipboard` is the modern replacement but only exposes a suspending
    // API with platform-specific `ClipEntry` construction; the manager still
    // works uniformly on every target we ship.
    @Suppress("DEPRECATION")
    val clipboard = LocalClipboardManager.current
    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current
    var copied by remember { mutableStateOf(false) }

    val highlighted = remember(code, scheme.isDark) {
        val highlights = Highlights.Builder()
            .code(code)
            .language(SyntaxLanguage.KOTLIN)
            .theme(SyntaxThemes.atom(darkMode = scheme.isDark))
            .build()
        buildAnnotatedString {
            append(code)
            highlights.getHighlights().forEach { highlight ->
                val style = when (highlight) {
                    is ColorHighlight -> SpanStyle(color = Color(highlight.rgb).copy(alpha = 1f))
                    is BoldHighlight -> SpanStyle(fontWeight = FontWeight.Bold)
                }
                addStyle(style, highlight.location.start, highlight.location.end)
            }
        }
    }

    LaunchedEffect(copied) {
        if (copied) {
            delay(CopiedFeedbackMillis)
            copied = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(YaruConstants.ButtonRadius))
            // A hair darker (lighter in dark mode) than the card it sits on, so
            // the snippet reads as an inset surface without adding a border.
            .background(
                if (scheme.isLight) {
                    scheme.onSurface.copy(alpha = 0.04f)
                } else {
                    Color.White.copy(alpha = 0.04f)
                },
            ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 4.dp, top = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            YaruText(
                text = "KOTLIN",
                style = typography.labelSmall,
                fontWeight = FontWeight.Medium,
                color = scheme.onSurfaceVariant,
            )
            YaruIconButton(
                onPressed = {
                    clipboard.setText(AnnotatedString(code))
                    copied = true
                },
                semanticLabel = "Copy code",
                icon = {
                    AnimatedContent(
                        targetState = copied,
                        transitionSpec = { fadeIn() togetherWith fadeOut() },
                    ) { isCopied ->
                        if (isCopied) {
                            YaruIcon(YaruIcons.ok_simple, tint = scheme.success)
                        } else {
                            YaruIcon(YaruIcons.copy, tint = scheme.onSurfaceVariant)
                        }
                    }
                },
            )
        }
        SelectionContainer {
            BasicText(
                text = highlighted,
                style = typography.bodySmall.copy(
                    fontFamily = FontFamily.Monospace,
                    color = scheme.onSurface,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
            )
        }
    }
}
