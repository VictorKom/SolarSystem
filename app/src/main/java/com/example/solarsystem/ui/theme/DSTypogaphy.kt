package com.example.solarsystem.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.solarsystem.R
import com.example.solarsystem.ui.theme.colors.DSColors
import com.example.solarsystem.ui.theme.colors.lightColors

private val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_bold, weight = FontWeight(700), style = FontStyle.Normal),
    Font(R.font.poppins_bold_italic, weight = FontWeight(700), style = FontStyle.Italic),
    Font(R.font.poppins_italic, weight = FontWeight(400), style = FontStyle.Italic),
    Font(R.font.poppins_medium, weight = FontWeight(500), style = FontStyle.Normal),
    Font(R.font.poppins_regular, weight = FontWeight(400), style = FontStyle.Normal),
    Font(R.font.poppins_semibold, weight = FontWeight(600), style = FontStyle.Normal),
    Font(R.font.poppins_semibold_italic, weight = FontWeight(600), style = FontStyle.Italic),
)

@Immutable
data class DSTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,
    val h6: TextStyle,
    val subtitle1: TextStyle,
    val subtitle2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val button: TextStyle,
    val caption: TextStyle,
    val overline: TextStyle
) {
    fun toMaterialTypography(): Typography {
        return Typography(
            h1 = h1,
            h2 = h2,
            h3 = h3,
            h4 = h4,
            h5 = h5,
            h6 = h6,
            subtitle1 = subtitle1,
            subtitle2 = subtitle2,
            body1 = body1,
            body2 = body2,
            button = button,
            caption = caption,
            overline = overline
        )
    }
}

internal val physicTypography: (DSColors) -> DSTypography = { colors ->
    DSTypography(
        h1 = Poppins(32, 36, 700, colors.textPrimary),
        h2 = Poppins(28, 32, 600, colors.textPrimary),
        h3 = Poppins(24, 28, 600, colors.textPrimary),
        h4 = Poppins(22, 24, 600, colors.textPrimary),
        h5 = Poppins(20, 24, 600, colors.textPrimary),
        h6 = Poppins(16, 20, 600, colors.textPrimary),
        body1 = Poppins(16, 24, 400, colors.textPrimary),
        body2 = Poppins(14, 20, 400, colors.textPrimary),
        subtitle1 = Poppins(16, 24, 400, colors.textPrimary),
        subtitle2 = Poppins(14, 20, 600, colors.textPrimary),
        caption = Poppins(12, 16, 400, colors.textPrimary),
        overline = Poppins(10, 12, 500, colors.textPrimary),
        button = Poppins(14, 16, 600, colors.textPrimary),
    )
}

private fun Poppins(
    fontSize: Int,
    lineHeight: Int,
    fontWeight: Int,
    color: Color
) = TextStyle(
    fontSize = fontSize.sp,
    lineHeight = lineHeight.sp,
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight(fontWeight),
    color = color
)

internal val LocalDSTypography = staticCompositionLocalOf { physicTypography(lightColors) }
