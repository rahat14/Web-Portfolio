package org.rahat.my_portfolio.utils

import WindowSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.rahat.my_portfolio.rememberWindowWidthDp

fun classifyWindowSize(widthDp: Int): WindowSize = when {
    widthDp < 600 -> WindowSize.COMPACT     // phones
    widthDp < 960 -> WindowSize.MEDIUM      // tablets / small desktops
    else -> WindowSize.EXPANDED             // large desktops / wide web
}

@Composable
fun rememberWindowSize(): WindowSize {
    val widthDp = rememberWindowWidthDp()
    return remember(widthDp) { classifyWindowSize(widthDp) }
}