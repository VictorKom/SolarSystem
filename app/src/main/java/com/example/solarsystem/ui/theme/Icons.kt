package com.example.solarsystem.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.solarsystem.R

class DSIcon private constructor(private val resId: Int) {

    @Composable
    fun toPainter() = painterResource(id = resId)

    class DSIcons {
        val help = DSIcon(R.drawable.ic_help)
        val arrowLeft = DSIcon(R.drawable.ic_arrow_left)
    }
}
