package com.otakkanan.sinote.ui.screens.profilScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.NavBar
import com.otakkanan.sinote.ui.components.PreviewTemplateMaxWidth
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.components.tugas.ReminderOption
import com.otakkanan.sinote.ui.navigations.Screen
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_primary2_200
import com.otakkanan.sinote.ui.theme.color_primary2_400
import com.otakkanan.sinote.ui.theme.color_primary2_50
import com.otakkanan.sinote.ui.theme.color_primary2_700
import com.otakkanan.sinote.ui.theme.color_primary2_800
import com.otakkanan.sinote.ui.theme.color_primary_50
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_white
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilScreen(navController: NavController) {
    val sheetState = rememberStandardBottomSheetState(SheetValue.PartiallyExpanded, skipHiddenState = false)
    val coroutineScope = rememberCoroutineScope()
    var openBottomSheet by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profil",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        },
        bottomBar = {
            NavBar(navController)
        }

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.post_image),
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Deva Agustina Deva Agustina ",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
            Column( // This is the profile menu card
                modifier = Modifier
                    .padding(16.dp)
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(10.dp)
                        shadowElevation = 8f
                        ambientShadowColor = color_primary2_50
                    }
                    .background(color = color_white)
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
            ) {
                ProfilMenuRow(R.drawable.profil_menu_person, "Akun", "Lengkapi akun anda",
                    onClick = {
                        navController.navigate(Screen.EditProfil.route)
                    })
                ProfilMenuRow(R.drawable.profil_menu_brush, "Tema", "Atur preferensi anda",
                    onClick = {
                        navController.navigate(Screen.Tema.route)
                    })
                ProfilMenuRow(R.drawable.profil_menu_task, "Tugas saya", "Daftar tugas anda", onClick = { /*TODO*/ })
                ProfilMenuRow(R.drawable.profil_menu_faq, "FAQ", "Pertanyaan umum",
                    onClick = {
                        navController.navigate(Screen.Faq.route)
                    })
                ProfilMenuRow(R.drawable.profil_menu_password, "Ubah kata sandi",
                    onClick = {
                        navController.navigate(Screen.ProfilChangePassword.route)
                    })
                ProfilMenuRow(R.drawable.profil_menu_logout, "Log out", "Amankan akun untuk keamanan",
                    onClick = {
                        coroutineScope.launch {
                            openBottomSheet = true
                            sheetState.show()
                        }
                    }
                )
            }
        }
    }

    if(openBottomSheet) {
        LogoutBottomSheet(
            sheetState = sheetState,
            onNoClick = {
                coroutineScope.launch {
                    sheetState.hide()
                    openBottomSheet = false
                }
            },
            onYesClick = {
                coroutineScope.launch {
                    sheetState.hide()
                    openBottomSheet = false
                }
                navController.navigate("auth_route")
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogoutBottomSheet(
    sheetState: SheetState,
    onNoClick: () -> Unit,
    onYesClick: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onNoClick,
        sheetState = sheetState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Keluar",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = color_primary_600,
                textAlign = TextAlign.Center,
            )
            Divider(
                modifier = Modifier.padding(top = 4.dp, bottom = 32.dp)
            )
            Text(
                text = "Apakah anda yakin akan keluar?",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(

            ) {
                OutlinedButton(
                    onClick = {
                              onNoClick()
                    },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, color_primary_600),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Tidak",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = color_primary_600,
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = {
                              onYesClick()
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Ya, Yakin",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ProfilBottomSheetPreview() {
    PreviewTemplateMaxWidth {
        LogoutBottomSheet(
            sheetState = rememberStandardBottomSheetState(initialValue = SheetValue.Expanded),
            onNoClick = {},
            onYesClick = {}
        )
    }
}

@Composable
fun ProfilMenuRow(
    iconId: Int,
    title: String,
    description: String? = null,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onClick() },
        contentPadding = PaddingValues(16.dp, 12.dp),
        border = BorderStroke(0.dp, Color.Transparent),
        shape = RectangleShape
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = color_primary_50)
            ) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = "Menu icon",
                    tint = color_primary_600
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = title, style = MaterialTheme.typography.titleSmall)
                if (description != null) {
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodySmall,
                        color = color_primary2_400
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                Icons.Filled.KeyboardArrowRight,
                contentDescription = "Right arrow icon",
                tint = color_primary2_400
            )
        }
    }
}



@Preview
@Composable
fun ProfilMenuRowPreview() {
    PreviewTemplateMaxWidth {
        ProfilMenuRow(R.drawable.profil_menu_person, "Akun", "Lengkapi akun anda", onClick = { /*TODO*/ })
    }
}

@Preview
@Composable
fun ProfilScreenPreview() {
    SiNoteTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            shadowElevation = 2.dp,
            color = Color.Blue
        ) {
            ProfilScreen(navController = mockNavController())
        }
    }
}