package com.otakkanan.sinote.ui.screens.profilScreens.tema

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.AddFab
import com.otakkanan.sinote.ui.components.AddItem
import com.otakkanan.sinote.ui.components.BottomNavItem
import com.otakkanan.sinote.ui.components.NavBar
import com.otakkanan.sinote.ui.components.PreviewTemplateMaxSize
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.components.tugas.CardTask
import com.otakkanan.sinote.ui.components.tugas.CardTaskData
import com.otakkanan.sinote.ui.navigations.Screen
import com.otakkanan.sinote.ui.screens.tugasScreens.Accordion
import com.otakkanan.sinote.ui.screens.tugasScreens.CategoryTabs
import com.otakkanan.sinote.ui.screens.tugasScreens.CustomTopAppBar
import com.otakkanan.sinote.ui.screens.tugasScreens.EmptyTugasImage
import com.otakkanan.sinote.ui.screens.tugasScreens.TugasListScreenPreview
import com.otakkanan.sinote.ui.theme.color_primary2_50
import com.otakkanan.sinote.ui.theme.color_primary2_800
import com.otakkanan.sinote.ui.theme.color_primary2_900
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_tugas_filter
import com.otakkanan.sinote.ui.theme.color_tugas_olahraga
import com.otakkanan.sinote.ui.theme.color_tugas_pekerjaan
import com.otakkanan.sinote.ui.theme.color_tugas_sekolah
import com.otakkanan.sinote.ui.theme.color_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemaCustomScreen(navController: NavController) {

    var selectedColor by remember { mutableStateOf(-1)}

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

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.KeyboardArrowLeft, "Navigate back", tint = color_white)
                    }
                },
                title = {
                    Text(
                        text = "Tema",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = color_white,
                        maxLines = 1,
                    )
                },
                actions = {
                    Text(
                        text = "Selesai",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .clickable(onClick = {
                                navController.popBackStack()
                            })
                            .padding(end = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = color_primary2_900
                )
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(color = color_primary2_900)
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                Box(
                    Modifier
                        .padding(horizontal = 32.dp, vertical = 16.dp)
                        .clip(RoundedCornerShape(24.dp))
                ) {
                    MockTugasListScreen()
                    Box(
                        Modifier
                            .matchParentSize()
                            .pointerInput(Unit) { detectTapGestures { } }
                    )
                }
            }
            Text(
                text = "Klik untuk memilih tema",
                color = color_white,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            ) {
                items(colors.size) {
                    TemaColorCard(
                        color = colors[it],
                        index = it,
                        selected = selectedColor
                    ) {
                        if(it == selectedColor) {
                            selectedColor = -1
                        } else {
                            selectedColor = it
                        }
                    }
                }
            }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockTugasListScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tugas",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(id = R.drawable.filter), contentDescription = "", tint = color_tugas_filter)
                    }
                }
            )
         },
        floatingActionButton = { AddFab {} },
        bottomBar = {

            val items = listOf(
                BottomNavItem.Catatan,
                BottomNavItem.Tugas,
                BottomNavItem.Inspirasi,
                BottomNavItem.Profil
            )

            NavigationBar(
                containerColor = color_primary2_50,
                tonalElevation = 1.dp,
                modifier = Modifier
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                        shadowElevation = 30f
                        ambientShadowColor = color_primary2_800
                    }
            )  {
                items.forEach { item ->
                    AddItem(
                        bottomNavItem = item,
                        navController = mockNavController(),
                        isCurrentRoute = item.screen.route == Screen.TugasList.route
                    )
                }
            }
        },
    ) { innerPadding ->
        Column(
            Modifier.padding(innerPadding)
        ) {
            CategoryTabs(onCategorySelected = {})
            Column(
                modifier = Modifier.padding(top = 16.dp)
            ) {
                EmptyTugasImage()
            }
        }
    }
}

@Preview
@Composable
fun TemaCustomScreenPreview() {
    PreviewTemplateMaxSize {
        TemaCustomScreen(navController = mockNavController())
    }
}