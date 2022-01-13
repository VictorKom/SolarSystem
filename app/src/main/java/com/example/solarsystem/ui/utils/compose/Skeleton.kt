package com.example.solarsystem.ui.utils.compose

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.solarsystem.ui.theme.DS

@Composable
fun Skeleton(
    modifier: Modifier = Modifier,
    shape: SkeletonShape
) {
    val animatedAlpha by rememberInfiniteTransition().animateFloat(
        initialValue = 1f,
        targetValue = .4f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 750,
                easing = CubicBezierEasing(.36f, 0f, .62f, 1f)
            ),
            RepeatMode.Reverse
        )
    )

    Box(modifier = modifier
        .run {
            when (shape) {
                is SkeletonShape.Text -> {
                    val texBlockLineHeight = with(LocalDensity.current) {
                        shape.textStyle.lineHeight.toDp()
                    }
                    requiredHeight(texBlockLineHeight).clip(shape.shape)
                }
                else -> clip(shape.shape)
            }
        }
        .graphicsLayer { alpha = animatedAlpha }
        .background(DS.colors.textTertiary)
    )
}

sealed class SkeletonShape(val shape: Shape) {

    private constructor(cornerRadius: Int) : this(RoundedCornerShape(cornerRadius.dp))

    object Circle : SkeletonShape(CircleShape)

    class Rectangle(cornerRadius: Int = 4) : SkeletonShape(cornerRadius)

    class Text(cornerRadius: Int = 4, val textStyle: TextStyle) : SkeletonShape(cornerRadius)
}