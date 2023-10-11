package com.example.expandabletext

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeplayground.R


@Composable
fun ExpandableTextExample() {
    Text(text = "Demo Clickable Text", modifier = Modifier.clickable(onClick = {}))
}

@Composable
fun ExpandableTextDemo() {
    var showMore = remember { mutableStateOf(false) }
    var isTextOverFlown = remember { mutableStateOf(false) }
    val text ="""
        Lorem Ipsum is simply dummy text of the printing and typesetting industry.
    """.trimIndent()
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .padding(15.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "profile",
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(
                            shape = CircleShape,
                            brush = Brush.verticalGradient(
                                colors = listOf(Color(0xFFED213A), Color(0xFF93291E))
                            ), width = 2.dp
                        )
                        .size(75.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                    Text(text = "Annie Armstrong", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(text = "Chief of Staff", fontSize = 13.sp)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = text,
                maxLines = if (showMore.value) Int.MAX_VALUE else 2,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = { textLayoutResult ->
                    isTextOverFlown.value = textLayoutResult.hasVisualOverflow
                })
            if (isTextOverFlown.value || showMore.value)
                Text(text = if (showMore.value) "Read less.." else "Read more..", color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { showMore.value = !showMore.value })
        }
    }
}

/*Image(
                    modifier = Modifier.rotate(if (showMore.value) -90f else 90f),
                    painter = painterResource(id = R.drawable.enter_arrow),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )*/
