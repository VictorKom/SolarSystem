package com.example.solarsystem.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
internal object DSRippleTheme : RippleTheme {

    @Composable
    override fun defaultColor(): Color {
        return if (isSystemInDarkTheme()) Color.White else DS.palette.teal900
    }

    @Composable
    override fun rippleAlpha() = RippleAlpha(
        draggedAlpha = .12f,
        focusedAlpha = .12f,
        hoveredAlpha = .08f,
        pressedAlpha = .12f
    )
}