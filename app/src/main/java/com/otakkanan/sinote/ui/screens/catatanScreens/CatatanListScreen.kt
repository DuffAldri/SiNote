package com.otakkanan.sinote.ui.screens.catatanScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.AddFab
import com.otakkanan.sinote.ui.components.NavBar
import com.otakkanan.sinote.ui.components.PreviewTemplateMaxSize
import com.otakkanan.sinote.ui.components.catatan.CatatanDataDummies
import com.otakkanan.sinote.ui.components.catatan.CatatanListCard
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.navigations.Screen
import com.otakkanan.sinote.ui.screens.tugasScreens.CustomTopAppBar
import com.otakkanan.sinote.ui.theme.color_primary2_400
import com.otakkanan.sinote.ui.theme.color_primary2_600
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_tugas_filter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatatanListScreen(navController: NavController, isNotEmpty: Boolean = true) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Catatan",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                    )
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(id = R.drawable.calendar), contentDescription = "", tint = MaterialTheme.colorScheme.primary)
                    }
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(id = R.drawable.filter), contentDescription = "", tint = color_tugas_filter)
                    }
                }
            )
        },
        floatingActionButton = { AddFab {navController.navigate(Screen.CreateCatatan.route)} },
        bottomBar = { NavBar(navController) },
    ) { innerPadding ->
        Column(
            Modifier.padding(innerPadding)
        ) {

            if(isNotEmpty) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    CatatanDataDummies.catatanList.forEachIndexed { index, catatanDataClass ->
                        item {
                            CatatanListCard(catatanDataClass = catatanDataClass)
                        }
                    }
                    
                }
            } else {
                EmptyNoteImage()
            }
        }
    }
}

@Composable
fun EmptyNoteImage() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.catatan_list_empty),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )

        Text(
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.belum_ada_catatan) + "\n" + stringResource(id = R.string.buat_catatan_anda_sekarang),
            style = MaterialTheme.typography.bodySmall,
            color = color_primary2_400,
            modifier = Modifier
                .padding(top = 16.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar() {
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
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteButton(onClick: () -> Unit) {
    FloatingActionButton(
        modifier = Modifier
            .size(48.dp),
        containerColor = color_primary_600,
        shape = RoundedCornerShape(8.dp),
        onClick = {onClick()}
    ) {
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(8.dp))
                .size(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Note", tint = Color.White, modifier = Modifier.size(16.dp))
        }
    }
}

@Preview
@Composable
fun CatatanListScreenPreview() {
    PreviewTemplateMaxSize {
        CatatanListScreen(navController = mockNavController())
    }
}