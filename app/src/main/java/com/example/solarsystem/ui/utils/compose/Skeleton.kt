package com.example.solarsystem.ui.utils.compose

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInteropFilter
import com.example.solarsystem.ui.theme.DS
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder

val LocalIsLoading = staticCompositionLocalOf<Boolean?> { null }

fun Modifier.skeleton(shape: Shape? = null) = composed {
    val isLoading = LocalIsLoading.current == true
    skeleton(isLoading = isLoading, shape = shape)
}

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.skeleton(isLoading: Boolean, shape: Shape? = null) = composed {
    placeholder(
        visible = isLoading,
        color = DS.colors.tintGray500,
        shape = shape ?: RectangleShape,
        highlight = PlaceholderHighlight.fade(
            highlightColor = DS.colors.tintGray300,
            animationSpec = infiniteRepeatable(
                animation = tween(delayMillis = 200, durationMillis = 1300),
                repeatMode = RepeatMode.Reverse
            )
        )
    )
        .run { if (isLoading) pointerInteropFilter { true } else this }
}
