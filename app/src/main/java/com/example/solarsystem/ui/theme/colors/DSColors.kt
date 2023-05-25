package com.example.solarsystem.ui.theme.colors

import androidx.compose.material.Colors
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class DSColors(
    val isLight: Boolean,

    val primaryLight: Color,
    val primary: Color,
    val primaryVariant: Color,
    val secondaryLight: Color,
    val secondary: Color,
    val secondaryVariant: Color,
    val background: Color,
    val backgroundSecondary: Color,
    val surface: Color,
    val error: Color,
    val onPrimary: Color,
    val onSecondary: Color,
    val onBackground: Color,
    val onSurface: Color,
    val onError: Color,

    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val tintGray300: Color,
    val tintGray500: Color,
) {
    fun toMaterialColors(): Colors {
        return Colors(
            primary = primary,
            primaryVariant = primaryVariant,
            secondary = secondary,
            secondaryVariant = secondaryVariant,
            background = background,
            surface = surface,
            error = error,
            onPrimary = onPrimary,
            onSecondary = onSecondary,
            onBackground = onBackground,
            onSurface = onSurface,
            onError = onError,
            isLight = isLight
        )
    }
}
