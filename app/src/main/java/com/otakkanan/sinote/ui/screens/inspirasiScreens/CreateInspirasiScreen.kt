package com.otakkanan.sinote.ui.screens.inspirasiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.inspirasi.InspirasiCard
import com.otakkanan.sinote.ui.components.inspirasi.InspirasiDataClass
import com.otakkanan.sinote.ui.components.inspirasi.createRandomInspirasiData
import com.otakkanan.sinote.ui.components.inspirasi.inspirasiDataDummy
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.components.tugas.membersDummy
import com.otakkanan.sinote.ui.screens.tugasScreens.AddMembersScreen
import com.otakkanan.sinote.ui.screens.tugasScreens.MemberCard
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_primary2_300
import com.otakkanan.sinote.ui.theme.color_primary2_700
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_textfield
import com.otakkanan.sinote.ui.theme.color_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateInspirasiScreen(navController: NavController, inspirasiDataClass: InspirasiDataClass) {
    var textfieldValue by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }
    val options = listOf("Publik", "Pribadi", "Brookly Simmons")
    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(options[0]) }

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
                actions = {
                    Text(
                        text = "Posting",
                        color = color_primary_600,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable {
                                navController.navigate("inspirasi_list") {
                                    popUpTo("inspirasi_list") {inclusive = true}
                                }
                            }
                    )
                }
            )
        },
        bottomBar = {
                    BottomAppBar(
                        containerColor = Color.Transparent,
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                        modifier = Modifier.height(64.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(painter = painterResource(id = R.drawable.select_image), contentDescription = null, tint = color_primary_600)
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(painter = painterResource(id = R.drawable.pinpoint), contentDescription = null, tint = color_primary_600)
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = "Bagikan: ",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                ExposedDropdownMenuBox(
                                    expanded = expanded,
                                    onExpandedChange = { expanded = !expanded },
                                ) {
                                    BasicTextField(
                                        value = text,
                                        onValueChange = {
                                            text = it
                                        },
                                        modifier = Modifier.menuAnchor(),
                                        readOnly = true,
                                        singleLine = true,
                                        textStyle = MaterialTheme.typography.bodyMedium.copy(color = color_primary_600, textAlign = TextAlign.End),
                                        decorationBox = @Composable {
                                            OutlinedTextFieldDefaults.DecorationBox(
                                                value = text,
                                                visualTransformation = VisualTransformation.None,
                                                innerTextField = it,
                                                singleLine = true,
                                                enabled = true,
                                                interactionSource = interactionSource,
                                                trailingIcon = {
                                                    if(expanded) {
                                                        Icon(
                                                            painter = painterResource(id = R.drawable.arrow___down_2),
                                                            contentDescription = null,
                                                            tint = color_primary_600,
                                                            modifier = Modifier.size(20.dp).rotate(180F)
                                                        )
                                                    } else {
                                                        Icon(
                                                            painter = painterResource(id = R.drawable.arrow___down_2),
                                                            contentDescription = null,
                                                            tint = color_primary_600,
                                                            modifier = Modifier.size(20.dp)
                                                        )
                                                    }
                                                },
                                                colors = OutlinedTextFieldDefaults.colors(),
                                                contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                                                    start = 12.dp,
                                                    top = 0.dp,
                                                    end = 0.dp,
                                                    bottom = 10.dp,
                                                ),
                                            )
                                        }
                                    )

                                    ExposedDropdownMenu(
                                        expanded = expanded,
                                        onDismissRequest = { expanded = false },
                                        modifier = Modifier.background(color = color_white)
                                    ) {
                                        options.forEach { option ->
                                            DropdownMenuItem(
                                                text = { Text(option, style = MaterialTheme.typography.bodyLarge) },
                                                onClick = {
                                                    text = option
                                                    expanded = false
                                                },
                                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                                            )
                                        }
                                    }
                                }                            }
                        }
                    }
        },
        modifier = Modifier
    ) { paddingValues ->
        Column (
            Modifier.padding(paddingValues)
        ) {
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Column(
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = inspirasiDataClass.profilePicture),
                        contentDescription = "${inspirasiDataClass.name}'s profile picture",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    OutlinedTextField(
                        value = textfieldValue,
                        onValueChange = {
                                        textfieldValue = it
                                        },
                        placeholder = {
                            Text(
                                "Tuliskan di sini...",
                                fontSize = 14.sp,
                                color = color_primary2_300,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        shape = RoundedCornerShape(5.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent
                        ),
//                        keyboardOptions = KeyboardOptions(
//                            imeAction = imeAction
//                        ),
                        minLines = 2,
                        modifier = Modifier
                            .onFocusChanged { focusState ->
                                isFocused = focusState.isFocused

                            }
                            .fillMaxWidth()
                            .weight(1f)
                    )

                }
            }
        }
    }
}

@Preview
@Composable
fun CreateInspirasiScreenPreview() {
    SiNoteTheme {
        Surface (
            modifier = Modifier
                .fillMaxSize()
        ) {
            CreateInspirasiScreen(navController = mockNavController(), inspirasiDataClass = inspirasiDataDummy)
        }
    }
}
