package org.rahat.my_portfolio.widget

import WindowSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.rahat.my_portfolio.data.Experience
import org.rahat.my_portfolio.theme.InterFontFamily
import org.rahat.my_portfolio.theme.SfMonoFontFamily
import org.rahat.my_portfolio.theme.offWhite
import org.rahat.my_portfolio.theme.textColor

@Composable
fun ExperienceCard(experience: Experience , windowSize: WindowSize) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
            focusedElevation = 1.dp
        )
    ) {

        Row(
            verticalAlignment = Alignment.Top ,
            horizontalArrangement =  Arrangement.Start
        ) {
            Text(
                experience.duration, style = TextStyle(
                    fontSize = if(windowSize == WindowSize.COMPACT){5.5.ssp}else { (5).ssp},
                    fontWeight = FontWeight.Medium,
                    color = textColor,
                    fontFamily = InterFontFamily()
                ),
                modifier = Modifier.width(65.sdp).padding(top = 1.sdp , start = 2.sdp)
            )

            Spacer(modifier = Modifier.size(if(windowSize == WindowSize.COMPACT){8.sdp}else 12.sdp))

            Column {

                Text(
                    "${experience.position} • ${experience.company}", style = TextStyle(
                        fontSize = if(windowSize == WindowSize.COMPACT){7.ssp}else { (6.5).ssp},
                        fontWeight = FontWeight.Medium,
                        color = offWhite,
                        fontFamily = InterFontFamily()
                    )
                )

                Spacer(modifier = Modifier.size(2.sdp))

                Text(
                    experience.responsibilities, style = TextStyle(
                        fontSize = if(windowSize == WindowSize.COMPACT){7.ssp}else { 6.ssp},
                        fontWeight = FontWeight.Normal,
                        color = textColor,
                        fontFamily = InterFontFamily() ,
                        lineHeight = 8.ssp

                    )
                )



                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(3.sdp),
                    verticalArrangement = Arrangement.spacedBy(2.sdp),
                    modifier = Modifier.padding(vertical = 5.sdp)
                ) {
                    for (item in experience.tech_stack) {
                        techStackItem(text = item , windowSize = windowSize)
                    }
                }


            }
        }

    }


}


@Composable
fun techStackItem(
    text: String,
    modifier: Modifier = Modifier ,
    windowSize: WindowSize
) {
    Box(
        modifier = modifier
            .background(
                color = Color(0xFF0A2239), // Dark background like the image
                shape = RoundedCornerShape(50)
            ).padding(horizontal = 5.sdp, vertical = if (windowSize != WindowSize.COMPACT){2.sdp}else {1.sdp}),
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = text,
            color = Color(0xFF16E3D1), // Bright cyan/teal color
            fontSize = if(windowSize == WindowSize.COMPACT){5.ssp}else { (4.5).ssp},
            fontWeight = FontWeight.Normal,
        )
    }
}