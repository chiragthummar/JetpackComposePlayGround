package com.example.jetpackcomposeplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.FixedScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

@Preview(showBackground = true)
@Composable
fun PreviewView() {
    JetpackComposePlayGroundTheme {
        Ex13()
    }
}

@Composable
fun Ex13() {
    Box(
        modifier = Modifier.aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = "https://play-lh.googleusercontent.com/Df7p_BJgR-ZShgqwD9KOWtI-FLG3FbRaY6-8hy5UPsV00Uq4gUeMund8hcuxQkwwMUo=w480-h960",
            contentDescription = null,
            contentScale = FixedScale(1f)
        )
        AsyncImage(
            modifier = Modifier
                .padding(32.dp)
                .shadow(
                    elevation = 14.dp,
                    shape = RoundedCornerShape(24.dp)
                )
                .graphicsLayer {
                    renderEffect = BlurEffect(
                        radiusX = 2.dp.toPx(),
                        radiusY = 2.dp.toPx()
                    )
                    shape = RoundedCornerShape(24.dp)
                    clip = true
                },
            model = "https://play-lh.googleusercontent.com/Df7p_BJgR-ZShgqwD9KOWtI-FLG3FbRaY6-8hy5UPsV00Uq4gUeMund8hcuxQkwwMUo=w480-h960",
            contentScale = FixedScale(1f),
            contentDescription = null,
        )
    }
}