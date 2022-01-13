package com.example.solarsystem.ui.theme.colors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.example.solarsystem.ui.theme.DS

val LocalSystemUiController: ProvidableCompositionLocal<SystemUiController?> =
    staticCompositionLocalOf { null }

@Composable
fun SystemBarsColor(color: Color = DS.colors.background) {
    val systemUiController = LocalSystemUiController.current
    SideEffect {
        systemUiController?.setSystemBarsColor(color = color)
    }
}
