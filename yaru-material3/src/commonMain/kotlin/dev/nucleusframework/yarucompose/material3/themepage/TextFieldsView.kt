package dev.nucleusframework.yarucompose.material3.themepage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons

/** Mirrors `yaru.dart/example/lib/pages/theme_page/src/textfields/text_fields_view.dart`. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldsView(modifier: Modifier = Modifier) {
    val initial =
        "My code fails, I do not know why.\nMy code works, I do not know why.\nText in other scripts: Tamaziɣt Taqbaylit, 中文(简体), Čeština, Беларуская, Ελληνικά, עברית, Русский, བོད་ཡིག, Norsk bokmål."
    var multiline by remember { mutableStateOf(TextFieldValue(initial, TextRange(initial.length))) }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    var dropdownExpanded by remember { mutableStateOf(false) }
    var dropdownValue by remember { mutableStateOf("") }

    LazyColumn(
        modifier = modifier.padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        item {
            Row {
                Button(onClick = {}, modifier = Modifier.weight(1f)) {
                    Text("Filled Button", maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                Spacer(Modifier.width(WrapSpacing.dp))
                OutlinedButton(onClick = {}, modifier = Modifier.weight(1f)) {
                    Text("Outlined Button", maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                Spacer(Modifier.width(WrapSpacing.dp))
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    modifier = Modifier.weight(1f),
                )
            }
        }
        item {
            TextField(
                value = "",
                onValueChange = {},
                enabled = false,
                label = { Text("Disabled") },
                modifier = Modifier.fillMaxWidth(),
            )
        }
        item {
            TextField(
                value = password,
                onValueChange = { password = it },
                visualTransformation = PasswordVisualTransformation(),
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
            )
        }
        item {
            TextField(
                value = error,
                onValueChange = { error = it },
                isError = true,
                supportingText = { Text("You're doing it wrong") },
                modifier = Modifier.fillMaxWidth(),
            )
        }
        item {
            TextField(
                value = multiline,
                onValueChange = { multiline = it },
                minLines = 5,
                maxLines = 5,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        item {
            ExposedDropdownMenuBox(
                expanded = dropdownExpanded,
                onExpandedChange = { dropdownExpanded = it },
            ) {
                OutlinedTextField(
                    value = dropdownValue,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { YaruIcon(YaruIcons.pan_down) },
                    modifier = Modifier.menuAnchor(),
                )
                DropdownMenu(
                    expanded = dropdownExpanded,
                    onDismissRequest = { dropdownExpanded = false },
                ) {
                    listOf("1", "2", "3").forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                dropdownValue = item
                                dropdownExpanded = false
                            },
                        )
                    }
                }
            }
        }
    }
}
