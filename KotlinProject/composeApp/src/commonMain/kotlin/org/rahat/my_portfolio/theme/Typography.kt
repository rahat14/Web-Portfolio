package org.rahat.my_portfolio.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.calibre_medium
import kotlinproject.composeapp.generated.resources.calibre_semibold
import kotlinproject.composeapp.generated.resources.sf_mono_medium
import kotlinproject.composeapp.generated.resources.sf_mono_regular
import kotlinproject.composeapp.generated.resources.sf_mono_semibold
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource


@Composable
fun CalibreFontFamily(): FontFamily {
    return FontFamily(
        fonts = listOf(
            Res.font.calibre_medium.asFont(fontWeight = FontWeight.Medium),
            Res.font.calibre_semibold.asFont(fontWeight = FontWeight.SemiBold),
        )
    )
}

@Composable
fun SfMonoFontFamily(): FontFamily {
    return FontFamily(
        fonts = listOf(
            Res.font.sf_mono_regular.asFont(fontWeight = FontWeight.Normal),
            Res.font.sf_mono_medium.asFont(fontWeight = FontWeight.Medium),
            Res.font.sf_mono_semibold.asFont(fontWeight = FontWeight.SemiBold),
            Res.font.sf_mono_semibold.asFont(fontWeight = FontWeight.Bold),
        )
    )
}

@Composable
fun FontResource.asFont(fontWeight: FontWeight): Font {
    return Font(resource = this, weight = fontWeight)
}