package com.example.solarsystem.ui.utils.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.solarsystem.ui.theme.DS
import com.example.solarsystem.ui.theme.DSIcon

@Composable
fun DSIconButton(
    modifier: Modifier = Modifier,
    icon: DSIcon,
    tint: Color = DS.colors.textPrimary,
    size: DSIconSize,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(size.size.dp)
            .clip(CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = icon.toPainter(),
            tint = tint,
            contentDescription = null
        )
    }
}

enum class DSIconSize(val size: Int) {
    SMALL(size = 24),
    MEDIUM(size = 32),
    LARGE(size = 40)
}
