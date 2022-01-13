package com.example.solarsystem.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.example.solarsystem.ui.theme.colors.DSColorPalette
import com.example.solarsystem.ui.theme.colors.DSColors
import com.example.solarsystem.ui.theme.colors.LocalDSColors

object DS {

    val colors: DSColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDSColors.current

    val typography: DSTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDSTypography.current

    val palette = DSColorPalette()

    val icons = DSIcon.DSIcons()
}
