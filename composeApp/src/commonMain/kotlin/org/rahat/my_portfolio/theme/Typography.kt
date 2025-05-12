package org.rahat.my_portfolio.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kotlinproject.composeapp.generated.resources.Inter_18pt_Medium
import kotlinproject.composeapp.generated.resources.Inter_18pt_Regular
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.sf_mono_medium
import kotlinproject.composeapp.generated.resources.sf_mono_regular
import kotlinproject.composeapp.generated.resources.sf_mono_semibold
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource


@Composable
fun InterFontFamily(): FontFamily {
    return FontFamily(
        fonts = listOf(
            Res.font.Inter_18pt_Medium.asFont(fontWeight = FontWeight.Medium),
//            Res.font.Inter_18pt_SemiBold.asFont(fontWeight = FontWeight.SemiBold),
            Res.font.Inter_18pt_Regular.asFont(fontWeight = FontWeight.Normal),
            Res.font.Inter_18pt_Medium.asFont(fontWeight = FontWeight.Bold),
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