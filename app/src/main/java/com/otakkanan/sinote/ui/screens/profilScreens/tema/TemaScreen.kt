package com.otakkanan.sinote.ui.screens.profilScreens.tema

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.PreviewTemplateMaxSize
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.navigations.Screen
import com.otakkanan.sinote.ui.theme.color_primary_400
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemaScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    val colors = listOf(
        Color(0xFF7DABF6),
        Color(0xFFEE89A9),
        Color(0xFF4DA8A3),
        Color(0xFF35343C),
        Color(0xFFFFFFFF),
        Color(0xFFDE6868),
        Color(0xFFF8C93B),
        Color(0xFF1D997F),
        Color(0xFFF59058),
        Color(0xFF9456DD),
    )

    val textures = listOf(
        R.drawable.tema_texture_1,
        R.drawable.tema_texture_2,
        R.drawable.tema_texture_3,
        R.drawable.tema_texture_4,
        R.drawable.tema_texture_1,
        R.drawable.tema_texture_2,
        R.drawable.tema_texture_3,
        R.drawable.tema_texture_4,
    )

    val landscapes = listOf(
        R.drawable.tema_pemandangan_1,
        R.drawable.tema_pemandangan_2,
        R.drawable.tema_pemandangan_3,
        R.drawable.tema_pemandangan_1,
        R.drawable.tema_pemandangan_2,
    )

    var selectedColor by remember { mutableStateOf(-1)}
    var selectedTexture by remember { mutableStateOf(-1)}
    var selectedLandscape by remember { mutableStateOf(-1)}

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()

                    }) {
                        Icon(Icons.Filled.KeyboardArrowLeft, "Navigate back")
                    }
                },
                title = {
                    Text(
                        text = "Tema",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            Text(
                text = "Warna Murni",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
            )
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.height(176.dp)
            ) {
                items(colors.size) {
                    TemaColorCard(color = colors[it], index = it, selected = selectedColor) {
                        if(it == selectedColor) {
                            selectedColor = -1
                        } else {
                            selectedColor = it
                        }
                    }
                }
            }
            Text(
                text = "Tekstur",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                items(textures.size) {
                    TemaTextureCard(
                        textureId = textures[it],
                        index = it,
                        selected = selectedTexture
                    ) {
                        if(it == selectedTexture) {
                            selectedTexture = -1
                        } else {
                            selectedTexture = it
                        }
                    }
                }
            }
            Text(
                text = "Pemandangan",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
            )
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.height((2 * 100 + 2 * 16 + 16).dp)
            ) {
                items(landscapes.size) {
                    TemaPemandanganCard(landscapes[it], index = it, selected = selectedLandscape) {
                        selectedLandscape = if(it == selectedLandscape) {
                            -1
                        } else {
                            it
                        }
                    }
                }
            }
            Text(
                text = "Kustomisasi",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable(
                        onClick = {
                            navController.navigate(Screen.TemaCustom.route)
                        }
                    )
                    .height(100.dp)
                    .width(200.dp)
                    .background(
                        brush = Brush.verticalGradient(listOf(color_primary_600, color_primary_400)),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Icon(Icons.Filled.Add, "Custom theme icon", tint = color_white)
            }
            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
fun TemaColorCard(color: Color, index:Int, selected: Int = -1, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .clickable(
                onClick = {
                    onClick()
                }
            )
            .size(80.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        if(selected == index)
            Icon(
                Icons.Filled.CheckCircle,
                "Selected",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .offset(6.dp, 6.dp)
                    .background(color_white, CircleShape)
                    .border(1.dp, color_white, CircleShape)
            )
    }
}

@Composable
fun TemaPemandanganCard(pemandanganId: Int, index: Int, selected: Int = -1, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .clickable(
                onClick = {onClick()}
            )
            .height(100.dp)
            .width(200.dp)
    ) {
        Image(
            painter = painterResource(id = pemandanganId),
            contentDescription = "Texture number $index",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(8.dp))
        )

        if(selected == index)
            Icon(
                Icons.Filled.CheckCircle,
                "Selected",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .offset(6.dp, 6.dp)
                    .background(color_white, CircleShape)
                    .border(1.dp, color_white, CircleShape)
            )
    }
}

@Composable
fun TemaTextureCard(textureId: Int, index: Int, selected: Int = -1, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .clickable(
                onClick = {onClick()}
            )
            .size(80.dp)
    ) {
        Image(
            painter = painterResource(id = textureId),
            contentDescription = "Texture number $index",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(8.dp))
            )
        if(selected == index)
            Icon(
                Icons.Filled.CheckCircle,
                "Selected",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .offset(6.dp, 6.dp)
                    .background(color_white, CircleShape)
                    .border(1.dp, color_white, CircleShape)
            )
    }
}

@Preview
@Composable
fun TemaScreenPreview() {
    PreviewTemplateMaxSize {
        TemaScreen(navController = mockNavController())
    }
}