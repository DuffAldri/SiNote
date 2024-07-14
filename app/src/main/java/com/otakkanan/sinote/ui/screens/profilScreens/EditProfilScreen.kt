package com.otakkanan.sinote.ui.screens.profilScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.CountryCodeSEA
import com.otakkanan.sinote.ui.components.Gender
import com.otakkanan.sinote.ui.components.NavBar
import com.otakkanan.sinote.ui.components.PreviewTemplateMaxSize
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.navigations.Screen
import com.otakkanan.sinote.ui.theme.color_primary2_300
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfilScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    var isFocused by remember { mutableStateOf(false) }

    // Textfields' states
    var nameTextfieldState by remember { mutableStateOf("") }
    var usernameTextfieldState by remember { mutableStateOf("") }

    var genderTextfieldState by remember { mutableStateOf("") }
    var isGenderExpanded by remember { mutableStateOf(false) }

    var emailTextfieldState by remember { mutableStateOf("") }

    var phoneTextfieldState by remember { mutableStateOf("") }
    var phoneCodeState by remember { mutableStateOf(CountryCodeSEA.IDN) }
    var isPhoneExpanded by remember { mutableStateOf(false) }

    var dateTextfieldState by remember { mutableStateOf("16/08/2002") }

    val isButtonEnabled = nameTextfieldState.isNotEmpty() &&
            usernameTextfieldState.isNotEmpty() &&
            genderTextfieldState.isNotEmpty() &&
            emailTextfieldState.isNotEmpty() &&
            phoneTextfieldState.isNotEmpty()

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
                        text = "Akun",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.post_image),
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(4.dp),
                    contentPadding = PaddingValues(2.dp),
                    modifier = Modifier
                        .size(28.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.profil_edit_profile),
                        contentDescription = "Edit profile picture",
                        tint = color_white
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            EditAkunTextfield(
                onValueChange = { nameTextfieldState = it },
                onFocusChange = { isFocused = it },
                value = nameTextfieldState,
                placeholder = "Masukkan nama anda",
            )
            EditAkunTextfield(
                onValueChange = { usernameTextfieldState = it },
                onFocusChange = { isFocused = it },
                value = usernameTextfieldState,
                placeholder = "Masukkan username",
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                OutlinedTextField(
                    singleLine = true,
                    value = dateTextfieldState,
                    onValueChange = {
                        dateTextfieldState = it
                    },
                    readOnly = true,
                    placeholder = {
                        Text(
                            "Tanggal lahir",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    ),
                    trailingIcon = {
                           Icon(painter = painterResource(id = R.drawable.profil_edit_calendar), contentDescription = "Calendar icon")
                    },
                    modifier = Modifier
                        .onFocusChanged {
                        }
                        .fillMaxWidth()
                )
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                ExposedDropdownMenuBox(
                    expanded = isGenderExpanded,
                    onExpandedChange = { isGenderExpanded = !isGenderExpanded }
                ) {
                    OutlinedTextField(
                        readOnly = true,
                        singleLine = true,
                        value = genderTextfieldState,
                        onValueChange = {
                            genderTextfieldState = it
                        },
                        placeholder = {
                            Text(
                                "Jenis kelamin",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        ),
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow___down_2),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .rotate(if (isGenderExpanded) 180f else 0f)
                            )
                        },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = isGenderExpanded,
                        onDismissRequest = { isGenderExpanded = false },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = color_white)
                    ) {
                        Gender.entries.forEach { entry ->
                            DropdownMenuItem(
                                text = { Text(entry.description, style = MaterialTheme.typography.bodyMedium) },
                                onClick = {
                                    genderTextfieldState = entry.description
                                    isGenderExpanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                }
            }

            EditAkunTextfield(
                onValueChange = { emailTextfieldState = it },
                onFocusChange = { isFocused = it },
                value = emailTextfieldState,
                placeholder = "Email",
                keyboardType = KeyboardType.Email
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                ExposedDropdownMenuBox(
                    expanded = isPhoneExpanded,
                    onExpandedChange = {  }
                ) {
                    OutlinedTextField(
                        singleLine = true,
                        value = phoneTextfieldState,
                        onValueChange = {
                            phoneTextfieldState = it
                        },
                        placeholder = {
                            Text(
                                "Nomor Telepon",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        ),
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        ),
                        leadingIcon = {
                            Row(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .clickable { isPhoneExpanded = !isPhoneExpanded }
                            ) {
                                Text(phoneCodeState.flagEmoji, style = MaterialTheme.typography.bodyMedium)
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow___down_2),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .rotate(if (isGenderExpanded) 180f else 0f)
                                )
                                Text(phoneCodeState.phoneCode, style = MaterialTheme.typography.bodyMedium)
                            }

                        },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = isPhoneExpanded,
                        onDismissRequest = { isPhoneExpanded = false },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = color_white)
                    ) {
                        CountryCodeSEA.entries.forEach { entry ->
                            DropdownMenuItem(
                                text = {
                                    Row() {
                                        Text(entry.flagEmoji, style = MaterialTheme.typography.bodyMedium)
                                        Spacer(Modifier.width(4.dp))
                                        Text(entry.country, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
                                        Text(entry.phoneCode, style = MaterialTheme.typography.bodyMedium)
                                    }
                                       },
                                onClick = {
                                    phoneCodeState = entry
                                    isPhoneExpanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    navController.navigate(Screen.Profil.route) {
                        popUpTo(Screen.Profil.route)
                    } },
                enabled = isButtonEnabled,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .height(IntrinsicSize.Max)
                    .fillMaxWidth(),
            ) {
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    text = "Simpan",
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
fun EditAkunTextfield(
    onValueChange: (String) -> Unit,
    onFocusChange: (Boolean) -> Unit,
    value: String,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        OutlinedTextField(
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            placeholder = {
                Text(
                    placeholder,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    overflow = TextOverflow.Ellipsis
                )
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            modifier = Modifier
                .onFocusChanged {
                    onFocusChange(it.isFocused)
                }
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun EditAccountScreenPreview() {
    PreviewTemplateMaxSize {
        EditProfilScreen(navController = mockNavController())

    }
}