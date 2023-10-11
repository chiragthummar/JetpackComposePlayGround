package com.example.jetpackcomposeplayground

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class BottomRoundedArcShape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawArcPath(size = size)
        )
    }
}

fun drawArcPath(size: Size): Path {
    return Path().apply {
        reset()


        val width = size.width + 350
        val height = size.height

        //go from (0,0) to (width, 0)
        lineTo(width, 0f)

        //go from (width, 0) to (width, height)
        lineTo(width, height)

        //draw an arch from (width,height) to (0, height)
        // starting from 0 degree to 180 degree


        arcTo(
            rect = Rect(
                Offset(-170f, 0f),
                Size(width, height)
            ),
            startAngleDegrees = 0f,
            sweepAngleDegrees = 180f,
            forceMoveTo = false
        )
//
//        //go from (0, height) to (0,0)
        lineTo(0f, 0f)
        close()

    }
}