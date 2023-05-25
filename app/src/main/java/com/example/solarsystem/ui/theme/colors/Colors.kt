package com.example.solarsystem.ui.theme.colors

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.solarsystem.ui.theme.DS

internal val LocalDSColors = staticCompositionLocalOf { lightColors }

val lightColors = run {
    val dark = DS.palette.black
    val bright = DS.palette.white
    DSColors(
        isLight = true,
        primaryLight = DS.palette.teal50,
        primary = DS.palette.teal700,
        primaryVariant = DS.palette.teal900,
        secondaryLight = DS.palette.amber400,
        secondary = DS.palette.amber500,
        secondaryVariant = DS.palette.amber600,
        background = bright,
        backgroundSecondary = DS.palette.gray150,
        surface = bright,
        error = DS.palette.red500,
        onPrimary = dark,
        onSecondary = dark,
        onBackground = bright,
        onSurface = bright,
        onError = dark,
        textPrimary = dark.copy(alpha = .87f),
        textSecondary = dark.copy(alpha = .60f),
        textTertiary = dark.copy(alpha = .38f),
        tintGray300 = DS.palette.gray300day,
        tintGray500 = DS.palette.gray500day,
    )
}

val darkColors = run {
    val dark = DS.palette.white
    val bright = DS.palette.black
    DSColors(
        isLight = false,
        primaryLight = DS.palette.teal200,
        primary = DS.palette.teal400,
        primaryVariant = DS.palette.teal600,
        secondaryLight = DS.palette.amber200,
        secondary = DS.palette.amber300,
        secondaryVariant = DS.palette.amber400,
        background = bright,
        backgroundSecondary = DS.palette.gray800,
        surface = bright,
        error = DS.palette.red500,
        onPrimary = dark,
        onSecondary = dark,
        onBackground = bright,
        onSurface = bright,
        onError = dark,
        textPrimary = dark.copy(alpha = .98f),
        textSecondary = dark.copy(alpha = .60f),
        textTertiary = dark.copy(alpha = .38f),
        tintGray300 = DS.palette.gray300night,
        tintGray500 = DS.palette.gray500night,
    )
}
