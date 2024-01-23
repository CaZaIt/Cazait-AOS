package org.cazait.cazaitandroid.core.designsystem.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.theme.SunsetOrange

@Composable
fun HorizontalDotLine(color: Color = SunsetOrange) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp),
    ) {
        val canvasWidth = size.width
        val yPosition = size.height
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 15f), 0f)

        drawLine(
            color = color,
            start = Offset(0f, yPosition),
            end = Offset(canvasWidth, yPosition),
            pathEffect = pathEffect,
            strokeWidth = 1.dp.toPx(),
        )
    }
}
