package com.example.solarsystem.ui.utils.compose

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.example.solarsystem.ui.theme.DS

@Composable
fun DSTopAppBar(title: String = "", back: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = DS.typography.h5
            )
        },
        navigationIcon = {
            DSIconButton(icon = DS.icons.arrowLeft, size = DSIconSize.LARGE, onClick = back)
        },
        backgroundColor = DS.colors.background
    )
}
