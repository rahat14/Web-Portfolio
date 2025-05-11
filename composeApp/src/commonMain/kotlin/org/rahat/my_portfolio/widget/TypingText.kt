package org.rahat.my_portfolio.widget

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle

import kotlinx.coroutines.delay

@Composable
fun TypingText(
    fullText: String,
    typingSpeed: Long = 50L,
    style: TextStyle = TextStyle()
) {
    var visibleText by remember { mutableStateOf("") }
    val characters = fullText.toCharArray()

    LaunchedEffect(fullText) {
        delay(500)

        visibleText = ""
        val builder = StringBuilder()
        characters.forEachIndexed { index, char ->
            builder.append(char)
            visibleText = builder.toString()
            delay(typingSpeed)
        }
    }

    Text(text = visibleText, style = style)
}