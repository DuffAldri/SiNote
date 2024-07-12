package com.otakkanan.sinote.ui.screens.tugasScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.AuthFormType
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.components.tugas.CategorySelector
import com.otakkanan.sinote.ui.components.tugas.CreateBottomSheet
import com.otakkanan.sinote.ui.components.tugas.CreateTugasTextField
import com.otakkanan.sinote.ui.components.tugas.DropDownButton
import com.otakkanan.sinote.ui.components.tugas.SubTugasTextField
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_form_bg
import com.otakkanan.sinote.ui.theme.color_primary2_100
import com.otakkanan.sinote.ui.theme.color_primary2_200
import com.otakkanan.sinote.ui.theme.color_primary2_300
import com.otakkanan.sinote.ui.theme.color_primary2_400
import com.otakkanan.sinote.ui.theme.color_primary2_600
import com.otakkanan.sinote.ui.theme.color_primary2_700
import com.otakkanan.sinote.ui.theme.color_primary_200
import com.otakkanan.sinote.ui.theme.color_primary_300
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_tugas_textfield
import com.otakkanan.sinote.ui.theme.color_white
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTugasScreen(navController: NavController) {
    var selectedKategori by remember { mutableStateOf("") }
    var judulTugas by remember { mutableStateOf("")}
    var deskripsiTugas by remember { mutableStateOf("")}
    var isAnyTextfieldFocused by remember { mutableStateOf(false)}
    val kategoriItems = listOf("Pekerjaan", "Sekolah", "Olahraga")
    var isKategoriExpanded by remember { mutableStateOf(false) }
    var subTugasList = remember { mutableStateListOf("") }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showPengingatBottomSheet by remember { mutableStateOf(false) }
    var selectedPengingat by remember { mutableStateOf<String?>(null) }
    var showUlangiTugasBottomSheet by remember { mutableStateOf(false) }
    var selectedUlangiTugas by remember { mutableStateOf<String?>(null) }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    text = "Buat Tugas",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = color_primary2_700,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            )
        },
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick =  {
                    isAnyTextfieldFocused = false
                }
            )
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
                .fillMaxWidth()
        ) {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                DropDownButton(
                    selectedKategori = selectedKategori,
                    onKategoriSelected = { selectedKategori = it },
                    isKategoriExpanded = isKategoriExpanded,
                    onKategoriExpandedChange = { isKategoriExpanded = it },
                    kategoriItems = kategoriItems
                )

                Row {
                    Text(
                        text = "Tenggat",
                        style = MaterialTheme.typography.bodyMedium,
                        color = color_primary_600,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(painter = painterResource(id = R.drawable.calendar), contentDescription = "Calendar icon")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Bagikan :",
                style = MaterialTheme.typography.bodyMedium
            )
            Row (verticalAlignment = Alignment.Bottom) {
                CategorySelector(modifier = Modifier.weight(1f))
                Row (verticalAlignment = Alignment.CenterVertically) {
                    Text("Tambah Anggota", style = MaterialTheme.typography.bodySmall, color =  color_primary2_300)
                    Spacer(Modifier.width(8.dp))
                    Icon(painter = painterResource(id = R.drawable.arrow___down_2), contentDescription = "Tambah anggota", tint = color_primary_600)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            CreateTugasTextField(
                value = judulTugas,
                onValueChange = {judulTugas = it},
                hideKeyboard = !isAnyTextfieldFocused,
                onFocusChanged = { isFocused ->
                    isAnyTextfieldFocused = isFocused
                },
                placeholder = "Tuliskan judul tugas di sini",
                minLines = 1
            )
            Spacer(modifier = Modifier.height(8.dp))
            CreateTugasTextField(
                value = deskripsiTugas,
                onValueChange = {deskripsiTugas = it},
                hideKeyboard = !isAnyTextfieldFocused,
                onFocusChanged = { isFocused ->
                    isAnyTextfieldFocused = isFocused
                },
                placeholder = "Tuliskan deskripsi di sini",
                minLines = 2
            )
            Spacer(modifier = Modifier.height(8.dp))
            subTugasList.forEachIndexed { index, text ->
                SubTugasTextField(
                    value = text,
                    onValueChange = { subTugasList[index] = it}
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.clickable {
                    subTugasList.add("")
                }
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(color = color_primary_200, shape = RoundedCornerShape(7.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Filled.Add, "Add sub-tugas", Modifier.size(15.dp), color_primary_600)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Tambahkan sub-tugas baru",
                    style = MaterialTheme.typography.bodyMedium,
                    color = color_primary_600,
                    modifier = Modifier.weight(1f)
                )
            }
            Divider(modifier = Modifier.padding(top = 12.dp, bottom = 4.dp), color = color_primary2_200)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.time_circle), "Ganti pengingat", Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Pengingat",
                    style = MaterialTheme.typography.bodyMedium,
                    color = color_primary_600,
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = { showPengingatBottomSheet = true },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = color_tugas_textfield,
                        contentColor = color_primary2_300,
                    ),
                    contentPadding = PaddingValues(vertical = 4.dp, horizontal = 4.dp)
                ) {
                    Text(text = selectedPengingat ?: "Tidak")
                }
            }
            Divider(modifier = Modifier.padding(vertical = 4.dp), color = color_primary2_200)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.swap), "Ulangi tugas", Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Ulangi Tugas",
                    style = MaterialTheme.typography.bodyMedium,
                    color = color_primary_600,
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = { showUlangiTugasBottomSheet = true },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = color_tugas_textfield,
                        contentColor = color_primary2_300,
                    ),
                    contentPadding = PaddingValues(vertical = 4.dp)
                ) {
                    Text(text = selectedUlangiTugas ?: "Tidak")
                }
            }
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navController.navigate("tugas") {
                        popUpTo("tugas")
                    } },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .height(IntrinsicSize.Max)
                    .fillMaxWidth(),
            ) {
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    text = stringResource(id = R.string.selanjutnya),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }

            if (showPengingatBottomSheet) {
                CreateBottomSheet(
                    title = "Pengingat",
                    sheetState = sheetState,
                    onDismiss = {
                        showPengingatBottomSheet = false
                    },
                    selectedOption = selectedPengingat,
                    onOptionSelected = {
                        selectedPengingat = it
                    },
                    optionList = listOf(
                        "Jatuh tempo",
                        "12 jam sebelumnya",
                        "1 hari sebelumnya",
                        "3 hari sebelumnya",
                        "1 minggu sebelumnya"
                        )
                )
            }
            if (showUlangiTugasBottomSheet) {
                CreateBottomSheet(
                    title = "Ulangi Tugas",
                    sheetState = sheetState,
                    onDismiss = {
                        showUlangiTugasBottomSheet = false
                    },
                    selectedOption = selectedUlangiTugas,
                    onOptionSelected = {
                                       selectedUlangiTugas = it
                    },
                    optionList = listOf(
                        "Setiap hari",
                        "Mingguan",
                        "Bulanan",
                        "Tahunan",
                    )
                )
            }

        }
    }
}

@Preview
@Composable
fun CreateTugasScreenPreview() {
    SiNoteTheme {
        Surface {
            CreateTugasScreen(navController = mockNavController())
        }
    }
}