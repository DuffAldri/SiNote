package com.otakkanan.sinote.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColorBox(name: String, color: Color) {
    Box(
        modifier = Modifier
            .background(color)
            .padding(16.dp)
    ) {
        Text(text = name)
    }
}

@Composable
fun ColorGrid(colorPairs: List<Pair<String, Color>>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(colorPairs) { colorPair ->
            ColorBox(name = colorPair.first, color = colorPair.second)
        }
    }
}

@Composable
@Preview
fun colorBoxPreview() {
    val colorPairs = listOf(
        "Background" to Color(red = 255, green = 251, blue = 254), // PaletteTokens.Neutral99
        "OnBackground" to Color(red = 28, green = 27, blue = 31), // PaletteTokens.Neutral10
        "Surface" to Color(red = 255, green = 251, blue = 254), // PaletteTokens.Neutral99
        "OnSurface" to Color(red = 28, green = 27, blue = 31), // PaletteTokens.Neutral10
        "SurfaceVariant" to Color(red = 231, green = 224, blue = 236), // PaletteTokens.NeutralVariant90
        "OnSurfaceVariant" to Color(red = 73, green = 69, blue = 79), // PaletteTokens.NeutralVariant30
        "Primary" to Color(red = 103, green = 80, blue = 164), // PaletteTokens.Primary40
        "OnPrimary" to Color(red = 255, green = 255, blue = 255), // PaletteTokens.Primary100
        "PrimaryContainer" to Color(red = 234, green = 221, blue = 255), // PaletteTokens.Primary90
        "OnPrimaryContainer" to Color(red = 33, green = 0, blue = 93), // PaletteTokens.Primary10
        "Secondary" to Color(red = 98, green = 91, blue = 113), // PaletteTokens.Secondary40
        "OnSecondary" to Color(red = 255, green = 255, blue = 255), // PaletteTokens.Secondary100
        "SecondaryContainer" to Color(red = 232, green = 222, blue = 248), // PaletteTokens.Secondary90
        "OnSecondaryContainer" to Color(red = 29, green = 25, blue = 43), // PaletteTokens.Secondary10
        "Tertiary" to Color(red = 125, green = 82, blue = 96), // PaletteTokens.Tertiary40
        "OnTertiary" to Color(red = 255, green = 255, blue = 255), // PaletteTokens.Tertiary100
        "TertiaryContainer" to Color(red = 255, green = 216, blue = 228), // PaletteTokens.Tertiary90
        "OnTertiaryContainer" to Color(red = 49, green = 17, blue = 29), // PaletteTokens.Tertiary10
        "Error" to Color(red = 179, green = 38, blue = 30), // PaletteTokens.Error40
        "OnError" to Color(red = 255, green = 255, blue = 255), // PaletteTokens.Error100
        "ErrorContainer" to Color(red = 249, green = 222, blue = 220), // PaletteTokens.Error90
        "OnErrorContainer" to Color(red = 65, green = 14, blue = 11), // PaletteTokens.Error10
        "InverseSurface" to Color(red = 49, green = 48, blue = 51), // PaletteTokens.Neutral20
        "InverseOnSurface" to Color(red = 244, green = 239, blue = 244), // PaletteTokens.Neutral95
        "InversePrimary" to Color(red = 208, green = 188, blue = 255), // PaletteTokens.Primary80
        "Outline" to Color(red = 121, green = 116, blue = 126), // PaletteTokens.NeutralVariant50
        "OutlineVariant" to Color(red = 202, green = 196, blue = 208), // PaletteTokens.NeutralVariant80
        "Scrim" to Color(red = 0, green = 0, blue = 0) // PaletteTokens.Neutral0
    )

    Surface(modifier = Modifier.fillMaxSize()) {
        ColorGrid(colorPairs = colorPairs)
    }


}