package org.rahat.my_portfolio.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.ProjectManagement
import kotlinproject.composeapp.generated.resources.Res
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.painterResource
import org.rahat.my_portfolio.theme.InterFontFamily
import org.rahat.my_portfolio.theme.SfMonoFontFamily
import org.rahat.my_portfolio.theme.offWhite
import org.rahat.my_portfolio.theme.textColor

@Composable
fun ProjectCard(
    title: String = "This is a title",
    details: String = "Currently, I'm a Senior Front-End Engineer at Klaviyo, specializing in accessibility. I contribute to the creation and maintenance of UI components that power Klaviyo’s frontend, ensuring our platform meets web accessibility standards and best practices to deliver an inclusive user experience.",
    techStack: List<String> = listOf("Java", "Kotlin"),
) {





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
            verticalAlignment = Alignment.Top,
            modifier = Modifier
        ) {


            Image(
                painter = painterResource(Res.drawable.ProjectManagement),
                contentDescription = " Icon",
                modifier = Modifier
                    .padding(top = 2.sdp)
                    .height(45.sdp).width(75.sdp)
                    .clip(RoundedCornerShape(4.sdp)),
                contentScale = ContentScale.Crop
            )




            Spacer(modifier = Modifier.size(4.sdp))

            Column(
            ) {

                Text(
                    title, style = TextStyle(
                        fontSize = 7.ssp,
                        fontWeight = FontWeight.SemiBold,
                        color = offWhite,
                        fontFamily = InterFontFamily()
                    )
                )

               Spacer(modifier = Modifier.size(1.sdp))

                Text(
                    details, style = TextStyle(
                        fontSize = 6.ssp,
                        fontWeight = FontWeight.Normal,
                        color = textColor,
                        fontFamily = InterFontFamily()
                    )
                )



                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.sdp),
                    modifier = Modifier.padding(vertical = 5.sdp)
                ) {
                    for (item in techStack) {
                        techStackItem(text = item)
                    }
                }


            }
        }

    }


}

