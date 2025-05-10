package org.rahat.my_portfolio

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rahat.my_portfolio.theme.SfMonoFontFamily

@Composable
fun App() {
    MaterialTheme(
        typography = Typography(defaultFontFamily = SfMonoFontFamily())
    ) {
            MainScreen()
    }


}
