package com.otakkanan.sinote.ui.screens.inspirasiScreens

import android.service.autofill.OnClickAction
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.otakkanan.sinote.ui.components.NavBar
import com.otakkanan.sinote.ui.components.inspirasi.InspirasiCard
import com.otakkanan.sinote.ui.components.inspirasi.createRandomInspirasiData
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.components.tugas.membersDummy
import com.otakkanan.sinote.ui.screens.tugasScreens.AddMembersScreen
import com.otakkanan.sinote.ui.screens.tugasScreens.MemberCard
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_primary2_700
import com.otakkanan.sinote.ui.theme.color_primary_600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InspirasiScreen(navController: NavController) {
    val data = createRandomInspirasiData(15)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Inspirasi",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        },
        floatingActionButton = { FloatingButton { navController.navigate("create_inspirasi") } },
        bottomBar = { NavBar(navController) },
        modifier = Modifier
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(data) { it ->
                InspirasiCard(inspirasiDataClass = it)
            }
        }
    }
}

@Composable
fun FloatingButton(onClick: () -> Unit = {}) {
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
            Icon(Icons.Filled.Add, contentDescription = "Add Task", tint = Color.White, modifier = Modifier.size(16.dp))
        }
    }
}

@Preview
@Composable
fun InspirasiScreenPreview() {
    SiNoteTheme {
        Surface (
            modifier = Modifier
                .fillMaxSize()
        ) {
            InspirasiScreen(navController = mockNavController())
        }
    }
}
