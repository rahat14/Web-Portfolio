package org.rahat.my_portfolio.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun ExperienceCard(experience: Experience) {

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
                    fontSize = 5.ssp,
                    fontWeight = FontWeight.Medium,
                    color = textColor,
                    fontFamily = InterFontFamily()
                ),
                modifier = Modifier.width(60.sdp).padding(top = 1.sdp)
            )

            Spacer(modifier = Modifier.size(12.sdp))

            Column {

                Text(
                    "${experience.position} • ${experience.company}", style = TextStyle(
                        fontSize = 7.ssp,
                        fontWeight = FontWeight.Medium,
                        color = offWhite,
                        fontFamily = InterFontFamily()
                    )
                )

                Spacer(modifier = Modifier.size(4.sdp))

                Text(
                    experience.responsibilities, style = TextStyle(
                        fontSize = 6.ssp,
                        fontWeight = FontWeight.Normal,
                        color = textColor,
                        lineHeight = 8.ssp,
                        fontFamily = InterFontFamily()
                    )
                )



                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.sdp),
                    modifier = Modifier.padding(vertical = 5.sdp)
                ) {
                    for (item in experience.tech_stack) {
                        techStackItem(text = item)
                    }
                }


            }
        }

    }


}


@Composable
fun techStackItem(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = Color(0xFF0A2239), // Dark background like the image
                shape = RoundedCornerShape(50)
            ).padding(horizontal = 5.sdp, vertical = 2.sdp),
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = text,
            color = Color(0xFF16E3D1), // Bright cyan/teal color
            fontSize = 6.ssp,
            fontWeight = FontWeight.Normal,
            fontFamily = SfMonoFontFamily()
        )
    }
}