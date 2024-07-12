package com.otakkanan.sinote.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.otakkanan.sinote.R

// Set of Material typography styles to start with
object AppFont {
    val Poppins = FontFamily(
        Font(R.font.poppins),
        Font(R.font.poppins_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_bold_italic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.poppins_extrabold, FontWeight.ExtraBold),
        Font(R.font.poppins_extrabold_italic, FontWeight.ExtraBold, FontStyle.Italic),
        Font(R.font.poppins_extralight, FontWeight.ExtraLight),
        Font(R.font.poppins_extralight_italic, FontWeight.ExtraLight, FontStyle.Italic),
        Font(R.font.poppins_light, FontWeight.Light),
        Font(R.font.poppins_light_italic, FontWeight.Light, FontStyle.Italic),
        Font(R.font.poppins_medium, FontWeight.Medium),
        Font(R.font.poppins_medium_italic, FontWeight.Medium, FontStyle.Italic),
        Font(R.font.poppins_semibold, FontWeight.SemiBold),
        Font(R.font.poppins_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.poppins_thin, FontWeight.Thin),
        Font(R.font.poppins_thin_italic, FontWeight.Thin, FontStyle.Italic),
        Font(R.font.poppins_black, FontWeight.Black),
        Font(R.font.poppins_black_italic, FontWeight.Black, FontStyle.Italic)
    )
}

private val defaultTypography = Typography()
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = AppFont.Poppins),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = AppFont.Poppins),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = AppFont.Poppins),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = AppFont.Poppins),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = AppFont.Poppins),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = AppFont.Poppins),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = AppFont.Poppins),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = AppFont.Poppins),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = AppFont.Poppins),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = AppFont.Poppins),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = AppFont.Poppins),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = AppFont.Poppins),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = AppFont.Poppins),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = AppFont.Poppins),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = AppFont.Poppins)

)