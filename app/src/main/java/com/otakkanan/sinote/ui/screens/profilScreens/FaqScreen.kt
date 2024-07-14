package com.otakkanan.sinote.ui.screens.profilScreens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.PreviewTemplateMaxSize
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.components.rememberImeState
import com.otakkanan.sinote.ui.theme.color_primary2_200
import com.otakkanan.sinote.ui.theme.color_primary2_400

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FaqScreen(navController: NavController) {
    var searchTextState by remember { mutableStateOf("") }

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = imeState.value) {
        if(imeState.value) {
            scrollState.scrollTo(scrollState.maxValue)
        }

    }

    val listQuestions = listOf(
        FaqData("Apa itu SiNote?", "Aplikasi manajemen tugas yang dirancang untuk membantu individu dan tim mengatur, melacak, dan menyelesaikan tugas-tugas dengan efisien dan efektif"),
        FaqData("Apa fitur utama yang dimiliki oleh SiNote?", "Aplikasi manajemen tugas yang dirancang untuk membantu individu dan tim mengatur, melacak, dan menyelesaikan tugas-tugas dengan efisien dan efektif"),
        FaqData("Bagaimana cara memulai menggunakan SiNote?", "Aplikasi manajemen tugas yang dirancang untuk membantu individu dan tim mengatur, melacak, dan menyelesaikan tugas-tugas dengan efisien dan efektif"),
        FaqData("Bagaimana keamanan data pengguna di SiNote?", "Aplikasi manajemen tugas yang dirancang untuk membantu individu dan tim mengatur, melacak, dan menyelesaikan tugas-tugas dengan efisien dan efektif"),
        FaqData("Apakah SiNote cocok untuk semua jenis proyek?", "Aplikasi manajemen tugas yang dirancang untuk membantu individu dan tim mengatur, melacak, dan menyelesaikan tugas-tugas dengan efisien dan efektif"),
        FaqData("Bagaimana keamanan data pengguna di SiNote?", "Aplikasi manajemen tugas yang dirancang untuk membantu individu dan tim mengatur, melacak, dan menyelesaikan tugas-tugas dengan efisien dan efektif"),
        FaqData("Apakah SiNote cocok untuk semua jenis proyek?", "Aplikasi manajemen tugas yang dirancang untuk membantu individu dan tim mengatur, melacak, dan menyelesaikan tugas-tugas dengan efisien dan efektif"),
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.KeyboardArrowLeft, "Navigate back")
                    }
                },
                title = {
                    Text(
                        text = "FAQ",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        },
        modifier = Modifier

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bagaimana  kami bisa membantu anda?",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleMedium
            )

            TextField(
                value = searchTextState,
                onValueChange = {
                    searchTextState = it
                },
                placeholder = {
                    Text(text = "Cari")
                },
                leadingIcon = {
                    Icon(Icons.Filled.Search, "Search icon",
                        modifier = Modifier
                            .size(24.dp)
                    )
                },

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Pertanyaan teratas",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Lihat semua",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .clickable {}
                )
            }

            listQuestions.forEach {
                FaqCard(it)
            }
        }
    }
}

data class FaqData(
    val title: String,
    val description: String
)

@Composable
fun FaqCard(faqData: FaqData) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(1.dp, color_primary2_200, shape = RoundedCornerShape(4.dp))
            .animateContentSize()
            .clickable {
                expanded = !expanded
            }
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = faqData.title,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(4.dp))

            if(expanded) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_remove_24),
                    contentDescription = "Close icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            } else {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Close icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        if(expanded) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = faqData.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

}

@Preview
@Composable
fun FaqScreenPreview() {
    PreviewTemplateMaxSize {
        FaqScreen(navController = mockNavController())
    }
}