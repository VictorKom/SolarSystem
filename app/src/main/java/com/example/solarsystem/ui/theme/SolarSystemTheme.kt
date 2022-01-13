package com.example.solarsystem.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.solarsystem.ui.theme.colors.LocalDSColors
import com.example.solarsystem.ui.theme.colors.LocalSystemUiController
import com.example.solarsystem.ui.theme.colors.darkColors
import com.example.solarsystem.ui.theme.colors.lightColors

@Composable
fun SolarSystemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) darkColors else lightColors
    val typography = physicTypography(colors)
    val systemUiController = rememberSystemUiController()
    MaterialTheme(
        colors = colors.toMaterialColors(),
        typography = typography.toMaterialTypography()
    ) {
        CompositionLocalProvider(
            LocalDSColors provides colors,
            LocalDSTypography provides typography,
            LocalRippleTheme provides DSRippleTheme,
            LocalSystemUiController provides systemUiController,
            content = content
        )
    }
}
