package com.otakkanan.sinote.ui.screens.tugasScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
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
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.components.tugas.CardTask
import com.otakkanan.sinote.ui.components.tugas.CardTaskData
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_primary2_400
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_tugas_filter
import com.otakkanan.sinote.ui.theme.color_tugas_olahraga
import com.otakkanan.sinote.ui.theme.color_tugas_pekerjaan
import com.otakkanan.sinote.ui.theme.color_tugas_sekolah
import com.otakkanan.sinote.ui.theme.color_white

@Composable
fun TugasListScreen(navController: NavController, isEmpty: Boolean = true) {
    Scaffold(
        topBar = { CustomTopAppBar() },
        floatingActionButton = { AddTaskButton {navController.navigate("create_tugas")} }

    ) { innerPadding ->
        val previousTasks = listOf(
            CardTaskData(
                title = "Memulai Pemrograman dengan Kotlin",
                date = "Rabu, 24 Agustus 2022",
                time = "22.15 WIB",
                category = "Olahraga",
                isProgress = true,
                progress = 1f,
                memberImages = listOf(R.drawable.member_image, R.drawable.member_image, R.drawable.member_image)
            )
        )

        val todayTasks = listOf(
            CardTaskData(
                title = "Membuat Laporan Harian",
                date = "Kamis, 3 Agustus 2022",
                time = "20.15 WIB",
                category = "Pekerjaan",
                isProgress = false,
                progress = 0f,
                memberImages = listOf()
            )
        )

        val incomingTasks = listOf(
            CardTaskData(
                title = "Memulai Pemrograman dengan Kotlin",
                date = "Rabu, 24 Agustus 2022",
                time = "22.15 WIB",
                category = "Sekolah",
                isProgress = true,
                progress = 0.6f,
                memberImages = listOf(R.drawable.member_image, R.drawable.member_image, R.drawable.member_image)
            )
        )

        Column(
            Modifier.padding(innerPadding)
        ) {
            CategoryTabs(selectedCategory = "Semua",onCategorySelected = {})
            Column(
                modifier = Modifier.padding(top = 16.dp)
            ) {
                if(isEmpty)
                    EmptyTugasImage()
                else{
                    Accordion("Sebelumnya") {
                        previousTasks.forEach{
                            CardTask(cardTaskData = it)
                        }
                    }
                    Accordion("Hari ini") {
                        todayTasks.forEach{
                            CardTask(cardTaskData = it)
                        }
                    }
                    Accordion("Akan Datang") {
                        incomingTasks.forEach{
                            CardTask(cardTaskData = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Accordion(title: String, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.clickable { expanded = !expanded }.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    tint = color_primary2_400,
                    contentDescription = if (expanded) "Collapse" else "Expand"
                )
            }
            if (expanded) {
                Box(modifier = Modifier.padding(start = 8.dp)) {
                    content()
                }
            }
        }
    }
}

@Composable
fun EmptyTugasImage() {
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
            painter = painterResource(id = R.drawable.emptytugas),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )

        Text(
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.belum_ada_tugas) + "\n" + stringResource(id = R.string.buat_tugas_anda_sekarang),
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

@Composable
fun AddTaskButton(onClick: () -> Unit) {
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

@Composable
fun CategoryTabs(selectedCategory: String = "", onCategorySelected: (String) -> Unit) {
    val categories = listOf("Semua" to color_white, "Pekerjaan" to color_tugas_pekerjaan, "Sekolah" to color_tugas_sekolah, "Olahraga" to color_tugas_olahraga)
    var selectedIndex by remember { mutableStateOf(0) }

    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        contentColor = Color.Black,
        edgePadding = 0.dp,
        divider = {},

    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = index == selectedIndex,
                onClick = {
                    selectedIndex = index
                    onCategorySelected(category.first)
                },
                text = {
                    val isSelected = selectedIndex == index
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        if(category.first != "Semua")
                            Box(modifier = Modifier
                                .offset(y = (-2).dp)
                                .size(10.dp)
                                .clip(CircleShape)
                                .background(category.second)
                            )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = category.first,
                            fontWeight =
                                if(isSelected)
                                    FontWeight.SemiBold
                                else
                                    FontWeight.Normal,
                            modifier = Modifier
                                .offset(y = if(isSelected) (-4).dp else 0.dp)
                        )
                    }

                }
            )
        }
    }
}

@Preview
@Composable
fun TugasListScreenPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            TugasListScreen(navController = mockNavController())
        }
    }
}

@Preview
@Composable
fun CategoryTabsPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            CategoryTabs(selectedCategory = "Semua", onCategorySelected = {})
        }
    }
}

