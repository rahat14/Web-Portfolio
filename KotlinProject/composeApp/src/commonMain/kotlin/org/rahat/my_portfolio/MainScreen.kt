package org.rahat.my_portfolio

import Section
import SocialLink
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.facebook
import kotlinproject.composeapp.generated.resources.github
import kotlinproject.composeapp.generated.resources.horizontral_line
import kotlinproject.composeapp.generated.resources.linkedin
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rahat.my_portfolio.data.DeveloperProfile
import org.rahat.my_portfolio.repo.ProfileRepository
import org.rahat.my_portfolio.theme.CalibreFontFamily
import org.rahat.my_portfolio.theme.InterFontFamily
import org.rahat.my_portfolio.theme.LightSlate
import org.rahat.my_portfolio.theme.Navy
import org.rahat.my_portfolio.theme.SfMonoFontFamily
import org.rahat.my_portfolio.theme.offWhite
import org.rahat.my_portfolio.theme.textColor
import org.rahat.my_portfolio.widget.ExperienceCard
import org.rahat.my_portfolio.widget.ProjectCard
import org.rahat.my_portfolio.widget.TypingText


@Composable
fun MainScreen(vm: ProfileViewModel = ProfileViewModel(repository = ProfileRepository())) {
    val uiState = vm.profileState


    val scrollState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val firstVisibleItemIndex = scrollState.firstVisibleItemIndex


    Box(
        modifier = Modifier.fillMaxSize()
            .background(Navy)
    ) {

        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.sdp)) {


            LeftContainer(
                modifier = Modifier.weight(1f).pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            val scrollDelta = event.changes.firstOrNull()?.scrollDelta?.y ?: 0f

                            if (scrollDelta != 0f) {
                                scope.launch {
                                    scrollState.animateScrollBy((scrollDelta * 2f)) // 250f
                                }
                            }
                        }
                    }
                },
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
                },
                firstVisibleItemIndex,
                uiState
            )

            Box(
                Modifier.fillMaxHeight()
                    .weight(0.3f)
                    .pointerInput(Unit) {
                        awaitPointerEventScope {
                            while (true) {
                                val event = awaitPointerEvent()
                                val scrollDelta = event.changes.firstOrNull()?.scrollDelta?.y ?: 0f

                                if (scrollDelta != 0f) {
                                    scope.launch {
                                        scrollState.animateScrollBy((scrollDelta * 2f)) // 250f
                                    }
                                }
                            }
                        }
                    }
            )


            RightContainer(modifier = Modifier.weight(1.3f), scrollState, uiState)


        }


    }


}

@Composable
fun RightContainer(modifier: Modifier, scrollState: LazyListState, uiState: DeveloperProfile?) {


    LazyColumn(modifier = modifier, state = scrollState) {

        item {
            Spacer(modifier = Modifier.size(28.sdp))
        }

        item {


            val longText = """
                I'm a mobile developer passionate about crafting robust, intuitive, and performant applications that bridge design and engineering across platforms. I thrive at the intersection of user experience and technology—bringing thoughtful UI to life with clean architecture and scalable code.

                Currently, I focus on building high-quality mobile experiences using Kotlin Multiplatform, Jetpack Compose, and Flutter. My expertise lies in leading the development of cross-platform apps, implementing architecture patterns, optimizing performance, and ensuring maintainability. I take pride in delivering features that not only work well but feel great to use.

                Over the years, I’ve worked across startups, agencies, and large-scale educational platforms—shaping products used by millions globally. From building DRM-protected media apps to mentoring juniors and converting legacy codebases to modern, modular solutions, I enjoy solving real-world challenges through elegant code.

                In my spare time, you’ll find me exploring new technologies, contributing to open-source projects like MRT Buddy, or just relaxing with a good book,  or a long walk through Hyrule with a Master Sword in hand.
            """.trimIndent()



            Text(
                text = longText, color = textColor, style = TextStyle(
                    fontSize = (5.8).ssp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = InterFontFamily()
                )
            )
        }

        item {
            Spacer(modifier = Modifier.height(12.sdp))
        }

        items(uiState?.experience?.size ?: 0) {
            if (uiState != null) {
                ExperienceCard( uiState.experience[it])
            }
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

        items(uiState?.projects?.size ?: 0) {
            if (uiState != null) {
                ProjectCard(
                    uiState.projects[it]
                )
            }

        }

    }

}

@Composable
fun LeftContainer(
    modifier: Modifier = Modifier,
    onScrollTap: (Section) -> Unit,
    firstVisibleItemIndex: Int,
    uiState: DeveloperProfile?
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {

        Spacer(Modifier.weight(0.2f))


        TypingText(
            fullText = "Rahatul Aseaikin",
            style = TextStyle(
                fontSize = 18.ssp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = CalibreFontFamily(),
                lineHeight = 0.ssp,
                color = offWhite,
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
            text = "Crafting accessible, pixel-perfect mobile experiences that delight and perform.",
            color = textColor,
            fontSize = 6.ssp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(vertical = 0.sdp),
            lineHeight = 8.ssp
        )

        Spacer(Modifier.height(50.sdp))



        Section.entries.forEach { section ->

            ScrollItem(
                section.label, modifier =
                    Modifier.clickable {
                        onScrollTap(
                            section
                        )
                    },
                firstVisibleItemIndex

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
        modifier = Modifier.fillMaxWidth().height(20.sdp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        SocialLink.entries.forEach { section ->
            val interactionSource = remember { MutableInteractionSource() }
            val isHovered by interactionSource.collectIsHoveredAsState()

            val normalSize = 10.sdp
            val hoveredSize = 14.sdp

            val targetSize = if (isHovered) hoveredSize else normalSize


            var icon = Res.drawable.github
            if(section ==  SocialLink.FB){
                icon  = Res.drawable.facebook
            }else if (section ==  SocialLink.Linkedlin){
                icon  = Res.drawable.linkedin
            }


            Image(
                painter = painterResource(icon),
                contentDescription = " Icon",
                Modifier.padding(bottom = 0.sdp).size(targetSize)
                    .clickable {
                    openLink(section.url)
                }.hoverable(interactionSource),
                colorFilter = ColorFilter
                    .tint(color = LightSlate)
            )

        }


        Spacer(Modifier.weight(1f))

    }


}

@Composable
fun ScrollItem(name: String = " ", modifier: Modifier, firstVisibleItemIndex: Int) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()


    val overrideHover = if (firstVisibleItemIndex == 0 && name == Section.About.label) {
        true
    } else if (
        firstVisibleItemIndex < 6 && name == Section.Experience.label && firstVisibleItemIndex != 0
    ) {
        true
    } else if (firstVisibleItemIndex >= 6 && name == Section.Projects.label) {
        true
    } else false

    val normalSize = 20.sdp
    val hoveredSize = 35.sdp

    val targetSize = if (isHovered || overrideHover) hoveredSize else normalSize

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
            colorFilter = ColorFilter.tint(if (isHovered || overrideHover) Color.White else offWhite)
        )

        Spacer(modifier = Modifier.size(2.sdp))

        Text(
            name, style = TextStyle(
                fontSize = 5.ssp,
                color = if (isHovered || overrideHover) Color.White else Color(0xff64748b),
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