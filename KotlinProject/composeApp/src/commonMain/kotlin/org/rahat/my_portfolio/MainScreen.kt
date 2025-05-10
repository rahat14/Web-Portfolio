package org.rahat.my_portfolio

import Section
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.facebook
import kotlinproject.composeapp.generated.resources.github
import kotlinproject.composeapp.generated.resources.horizontral_line
import kotlinproject.composeapp.generated.resources.linkedin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rahat.my_portfolio.theme.CalibreFontFamily
import org.rahat.my_portfolio.theme.InterFontFamily
import org.rahat.my_portfolio.theme.LightSlate
import org.rahat.my_portfolio.theme.Navy
import org.rahat.my_portfolio.theme.SfMonoFontFamily
import org.rahat.my_portfolio.theme.offWhite
import org.rahat.my_portfolio.theme.textColor
import org.rahat.my_portfolio.widget.ExperienceCard
import org.rahat.my_portfolio.widget.ProjectCard


@Composable
fun MainScreen() {
    val scrollState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize().background(Navy)) {

        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.sdp)) {


            LeftContainer(modifier = Modifier.weight(1f) ,
                onScrollTap = { section ->
                    when (section) {
                        Section.Experience -> {
                            scope.launch {
                                scrollState.animateScrollToItem(3)
                            }

                        }
                        Section.Projects -> {
                            scope.launch {
                                scrollState.animateScrollToItem(8)
                            }
                        }
                        else -> {
                            scope.launch {
                                scrollState.animateScrollToItem(0)
                            }
                        }
                    }
                }
            )
            Spacer(Modifier.weight(0.3f))
            RightContainer(modifier = Modifier.weight(1.3f) , scrollState)


        }


    }


}

@Composable
fun RightContainer(modifier: Modifier, scrollState: LazyListState) {


    LazyColumn(modifier = modifier , state = scrollState) {

        item {
            Spacer(modifier = Modifier.size(28.sdp))
        }

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
            Spacer(modifier = Modifier.height(12.sdp))
        }

        item {
            Row(
                modifier = Modifier.padding(vertical = 12.sdp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Some Things I’ve Built",
                    style = TextStyle(
                        fontSize = 7.ssp,
                        fontWeight = FontWeight.Bold,
                        color = offWhite,
                        fontFamily = SfMonoFontFamily()
                    ),

                    )
                Spacer(modifier = Modifier.width(0.sdp))

                Image(
                    painter = painterResource(Res.drawable.horizontral_line),
                    contentDescription = "horizontral line",
                    modifier = Modifier
                        .height((1).sdp)
                        .width(100.sdp),
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(offWhite)
                )

            }

            Spacer(modifier = Modifier.height(8.sdp))
        }

        items(5) {
            ProjectCard()
            Spacer(modifier = Modifier.height(8.sdp))
        }

    }

}

@Composable
fun LeftContainer(modifier: Modifier = Modifier, onScrollTap: (Section) -> Unit) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {

        Spacer(Modifier.weight(0.2f))


        Text(
            text = "Rahatul Aseaikin", color = offWhite, style = TextStyle(
                fontSize = 18.ssp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = CalibreFontFamily(),
                lineHeight = 0.ssp
            )
        )

        Text(
            text = "Mobile Application Developer", color = offWhite, style = TextStyle(
                fontSize = 8.ssp,
                fontWeight = FontWeight.Medium,
                fontFamily = InterFontFamily()
            ),
            modifier = Modifier
        )

        Spacer(Modifier.height(5.sdp))

        Text(
            text = "I build accessible, pixel-perfect digital experiences for the web.",
            color = textColor,
            fontSize = 6.ssp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(vertical = 0.sdp),
            lineHeight = 8.ssp
        )

        Spacer(Modifier.height(50.sdp))



        Section.entries.forEach { section ->

            ScrollItem(section.name.toString().uppercase() , modifier =
                Modifier.clickable {
                    onScrollTap(
                        section
                    )
                }

            )

        }


        Spacer(Modifier.weight(1f))


        IconListContainer()

        Spacer(Modifier.weight(0.1f))


    }

}

@Composable
fun IconListContainer() {

    Row(
        horizontalArrangement = Arrangement.spacedBy(6.sdp),
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(Res.drawable.github),
            contentDescription = "Github Icon",
            Modifier.padding(bottom = 1.sdp).size(10.sdp),
            colorFilter = ColorFilter
                .tint(color = LightSlate)
        )

        Image(
            painter = painterResource(Res.drawable.facebook),
            contentDescription = "facebook Icon",
            Modifier.size(10.sdp),
            colorFilter = ColorFilter
                .tint(color = LightSlate)
        )

        Image(
            painter = painterResource(Res.drawable.linkedin),
            contentDescription = "LinkedIn Icon",
            Modifier.size(10.sdp),
            colorFilter = ColorFilter
                .tint(color = LightSlate)
        )

        Spacer(Modifier.weight(1f))

    }


}

@Composable
fun ScrollItem(name: String = " " , modifier: Modifier) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val normalSize = 20.sdp
    val hoveredSize = 35.sdp

    val targetSize = if (isHovered) hoveredSize else normalSize

    val animatedSize by animateDpAsState(
        targetValue = targetSize,
        label = "sizeAnimation"
    )

    Row(
        modifier = modifier.padding(vertical = 4.sdp).hoverable(interactionSource),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Image(
            painter = painterResource(Res.drawable.horizontral_line),
            contentDescription = "horizontal line",
            modifier = Modifier.height((1).sdp).width(animatedSize),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(if (isHovered) Color.White else offWhite)
        )

        Spacer(modifier = Modifier.size(2.sdp))

        Text(
            name, style = TextStyle(
                fontSize = 5.ssp,
                color = if (isHovered) Color.White else Color(0xff64748b),
                fontWeight = FontWeight.Bold,
                fontFamily = SfMonoFontFamily()
            ), modifier = Modifier


        )
    }
}

@Preview()
@Composable
fun AppPreview() {
    App()
}