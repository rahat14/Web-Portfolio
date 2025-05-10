package org.rahat.my_portfolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.facebook
import kotlinproject.composeapp.generated.resources.github
import kotlinproject.composeapp.generated.resources.linkedin
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rahat.my_portfolio.theme.Navy
import org.rahat.my_portfolio.theme.offWhite
import org.rahat.my_portfolio.theme.textColor
import org.rahat.my_portfolio.widget.ExperienceCard
import org.rahat.my_portfolio.widget.ProjectCard

@Composable
fun MainScreen() {

    Box(modifier = Modifier.fillMaxSize().background(Navy)) {

        Row(modifier = Modifier.fillMaxWidth().padding(24.sdp)) {


            LeftContainer(modifier = Modifier.weight(1f))
            Spacer(Modifier.weight(0.3f))
            RightContainer(modifier = Modifier.weight(1.3f))


        }


    }


}

@Composable
fun RightContainer(modifier: Modifier) {

    LazyColumn(modifier = modifier) {

        item {

            val longText =
                "I’m a developer passionate about crafting accessible, pixel-perfect user interfaces that blend thoughtful design with robust engineering." +
                        " My favorite work lies at the intersection of design and development, creating experiences that not only look great but are meticulously built for performance and usability. Currently," +
                        " I'm a Senior Front-End Engineer at Klaviyo, specializing in accessibility. "


            Text(
                text = longText, color = textColor, style = TextStyle(
                    fontSize = 7.ssp,
                    fontWeight = FontWeight.W400,
                )
            )
        }

        item {
            Spacer(modifier = Modifier.height(12.sdp))
        }

        items(5) {
            ExperienceCard()
            Spacer(modifier = Modifier.height(8.sdp))
        }


        item {
            Spacer(modifier = Modifier.height(20.sdp))
        }

        items(5) {
            ProjectCard()
            Spacer(modifier = Modifier.height(8.sdp))
        }

    }

}

@Composable
fun LeftContainer(modifier: Modifier) {

    Column(modifier = modifier) {

        //  Spacer(Modifier.weight(0.2f))


        Text(
            text = "Rahatul Aseaikin", color = offWhite, style = TextStyle(
                fontSize = 18.ssp,
                fontWeight = FontWeight.W700
            )
        )

        Text(
            text = "Mobile Application Developer", color = offWhite, style = TextStyle(
                fontSize = 8.ssp,
                fontWeight = FontWeight.W600
            ),
            modifier = Modifier.padding(vertical = 6.sdp)
        )

        Text(
            text = "I build accessible, pixel-perfect digital experiences for the web.",
            color = textColor,
            fontSize = 7.ssp,
            modifier = Modifier.padding(vertical = 0.sdp)
        )

        Spacer(Modifier.height(50.sdp))


        ScrollItem()
        ScrollItem()
        ScrollItem()

        Spacer(Modifier.weight(1f))


        IconListContainer()


    }

}

@Composable
fun IconListContainer() {

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.sdp),
        modifier = Modifier.fillMaxWidth(),

        ) {
        Spacer(Modifier.weight(1f))


        Image(
            painter = painterResource(Res.drawable.github),
            contentDescription = "Github Icon",
            Modifier.size(15.sdp),
            colorFilter = ColorFilter.tint(color = offWhite)
        )

        Image(
            painter = painterResource(Res.drawable.facebook),
            contentDescription = "facebook Icon",
            Modifier.size(15.sdp),
            colorFilter = ColorFilter.tint(color = offWhite)
        )

        Image(
            painter = painterResource(Res.drawable.linkedin),
            contentDescription = "LinkedIn Icon",
            Modifier.size(15.sdp),
            colorFilter = ColorFilter.tint(color = offWhite)
        )

        Spacer(Modifier.weight(1f))

    }


}

@Composable
fun ScrollItem() {
    Row(
        modifier = Modifier.padding(vertical = 4.sdp)
    ) {
        Text(
            "----  ABOUT", style = TextStyle(
                fontSize = 7.ssp,
                color = Color(0xff64748b),
                fontWeight = FontWeight.W500
            )
        )
    }
}

@Preview()
@Composable
fun AppPreview() {
    App()
}