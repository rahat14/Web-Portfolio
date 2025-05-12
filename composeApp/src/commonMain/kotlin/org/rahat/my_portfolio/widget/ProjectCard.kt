package org.rahat.my_portfolio.widget

import WindowSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.arrow
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.jetbrains.compose.resources.painterResource
import org.rahat.my_portfolio.data.Project
import org.rahat.my_portfolio.openLink
import org.rahat.my_portfolio.theme.Green
import org.rahat.my_portfolio.theme.InterFontFamily
import org.rahat.my_portfolio.theme.SfMonoFontFamily
import org.rahat.my_portfolio.theme.offWhite
import org.rahat.my_portfolio.theme.textColor

@Composable
fun ProjectCard(project: Project, windowSize: WindowSize) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val normalSize = 6.sdp
    val hoveredSize = 7.sdp

    val targetSize = if (isHovered) hoveredSize else normalSize

    val paddingSize = if (isHovered) 2.sdp else 1.sdp

    val animatedPaddingSize by animateDpAsState(
        targetValue = paddingSize,
        label = "sizePaddingAnimation"
    )

    val animatedSize by animateDpAsState(
        targetValue = targetSize,
        label = "sizeAnimation"
    )


    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                openLink(project.link)
            }
            .hoverable(interactionSource),
        colors = CardDefaults.cardColors(
            containerColor = if (isHovered) {
                Color.White.copy(alpha = 0.05f)
            } else Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
            focusedElevation = 0.dp
        )
    ) {

        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(4.sdp)
        ) {


            val painterResource = asyncPainterResource(data = project.image.toString())


            KamelImage(
                { painterResource }, contentDescription = " Icon",
                modifier = Modifier
                    .padding(top = 2.sdp)
                    .height(40.sdp).width(70.sdp)
                    .clip(RoundedCornerShape(4.sdp)),
                contentScale = ContentScale.Crop,
                onFailure = {
                    println("Failed to load image: ${project.image}. Error: $it")
                }
            )




            Spacer(modifier = Modifier.size(4.sdp))

            Column(
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier,
                ) {
                    Text(
                        project.name, style = TextStyle(
                            fontSize = if(windowSize == WindowSize.COMPACT){7.ssp}else { 6.ssp},
                            fontWeight = FontWeight.Bold,
                            color = if (isHovered) Green else offWhite,
                            fontFamily = SfMonoFontFamily()
                        )
                    )

                    Image(
                        painter = painterResource(Res.drawable.arrow),
                        contentDescription = " Icon",
                        modifier = Modifier
                            .padding(
                                bottom = animatedPaddingSize,
                                start = animatedPaddingSize
                            )
                            .height(animatedSize).width(animatedSize),
                        contentScale = ContentScale.Crop,

                        colorFilter = ColorFilter.tint(if (isHovered) Green else offWhite)
                    )


                }

                Spacer(modifier = Modifier.size(3.sdp))

                Text(
                    project.description, style = TextStyle(
                        fontSize = if(windowSize == WindowSize.COMPACT){7.ssp}else { 6.ssp},
                        fontWeight = FontWeight.Normal,
                        color = textColor,
                        fontFamily = InterFontFamily()
                    )
                )



                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(3.sdp),
                    modifier = Modifier.padding(vertical = 5.sdp),
                    verticalArrangement = Arrangement.spacedBy(2.sdp)
                ) {
                    for (item in project.tech_stack) {

                        techStackItem(text = item , windowSize = windowSize)
                    }
                }


            }
        }

    }


}

