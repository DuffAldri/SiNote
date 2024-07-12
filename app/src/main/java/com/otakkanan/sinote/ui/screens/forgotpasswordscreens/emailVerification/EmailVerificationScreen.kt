package com.otakkanan.sinote.ui.screens.forgotpasswordscreens.emailVerification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_primary2_100
import com.otakkanan.sinote.ui.theme.color_primary_600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailVerificationScreen(navController: NavController) {
    var isAnyTextfieldFocused by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    var remainingTime by remember { mutableStateOf(0) }
    var otpValue by remember { mutableStateOf("") }
    val email: String = "devaagustina@gmail.com"


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        stringResource(id = R.string.lupa_kata_sandi_title),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_left_2),
                            contentDescription = "Back"
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
    ) {innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .verticalScroll(state = scrollState)
                .fillMaxWidth()
        ) {
            val text = buildAnnotatedString {
                append(stringResource(id = R.string.kirim_ulang_kode_dalam))
                withStyle(style = SpanStyle(color = color_primary_600)) {
                    append(" $remainingTime ")
                }
                append(stringResource(id = R.string.detik))
            }

            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.kode_verifikasi_telah_dikirim),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
            )

            Text(
                textAlign = TextAlign.Center,
                text = email,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(16.dp))

            BasicTextField(
                value = otpValue,
                onValueChange = { if(it.length <= 4) otpValue = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword
                ),
                decorationBox = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        repeat(times = 4) { index ->
                            val char = when {
                                index >= otpValue.length -> ""
                                else -> otpValue[index].toString()
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(56.dp)
                                    .height(48.dp)
                                    .background(
                                        color = color_primary2_100,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .padding(2.dp)
                            ) {
                                Text(
                                    text = char,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }

                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                textAlign = TextAlign.Center,
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
            )

            Button(
                onClick = {navController.navigate("email_verification")},
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .height(IntrinsicSize.Max)
                    .fillMaxWidth(),
            ) {
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    text = stringResource(id = R.string.verifikasi),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun EmailVerificationScreenPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            EmailVerificationScreen(navController = mockNavController())
        }
    }
}