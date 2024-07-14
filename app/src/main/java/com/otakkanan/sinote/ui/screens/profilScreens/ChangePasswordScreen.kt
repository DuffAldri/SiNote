package com.otakkanan.sinote.ui.screens.profilScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.otakkanan.sinote.ui.components.AuthForm
import com.otakkanan.sinote.ui.components.AuthFormType
import com.otakkanan.sinote.ui.components.PreviewTemplateMaxSize
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.components.rememberImeState
import com.otakkanan.sinote.ui.theme.color_primary2_600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePasswordScreen(navController: NavController) {

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    var oldPasswordState by remember { mutableStateOf("12345678") }
    var newPasswordState by remember { mutableStateOf("") }
    var repeatNewPasswordState by remember { mutableStateOf("") }

    var isAnyTextfieldFocused by remember { mutableStateOf(false) }

    var isTextfieldFilled = oldPasswordState.isNotEmpty() && newPasswordState.isNotEmpty() && repeatNewPasswordState.isNotEmpty()

    LaunchedEffect(key1 = imeState.value) {
        if(imeState.value) {
            scrollState.scrollTo(scrollState.maxValue)
        }

    }

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text="Ubah Kata Sandi",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                    )
                },
                actions = {
                    Text(
                        text = "Selesai",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isTextfieldFilled) {
                            MaterialTheme.colorScheme.primary
                        } else {
                               color_primary2_600
                               },
                        modifier = Modifier
                            .clickable(
                                enabled = isTextfieldFilled,
                                onClick = {
                                navController.popBackStack()
                            })
                            .padding(end = 16.dp)
                    )
                },
            )
        },
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick =  {
//                    hideKeyboard = true
                    isAnyTextfieldFocused = false
                }
            )
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            AuthForm(
                title = "Kata sandi saat ini",
                placeholder = "Masukkan sandi saat ini",
                authFormType = AuthFormType.PASSWORD,
                value = oldPasswordState,
                onValueChange = { oldPasswordState = it },
                imeAction = ImeAction.Next,
                hideKeyboard = !isAnyTextfieldFocused,
                onFocusChanged = { isFocused ->
                    isAnyTextfieldFocused = isFocused
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            AuthForm(
                title = "Kata sandi baru",
                placeholder = "Masukkan sandi baru",
                authFormType = AuthFormType.PASSWORD,
                value = newPasswordState,
                onValueChange = { newPasswordState = it },
                imeAction = ImeAction.Next,
                hideKeyboard = !isAnyTextfieldFocused,
                onFocusChanged = { isFocused ->
                    isAnyTextfieldFocused = isFocused
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            AuthForm(
                title = "Konfirmasi kata sandi baru",
                placeholder = "Konfirmasi kata sandi baru",
                authFormType = AuthFormType.REPEAT_PASSWORD,
                value = repeatNewPasswordState,
                onValueChange = { repeatNewPasswordState = it },
                imeAction = ImeAction.Next,
                hideKeyboard = !isAnyTextfieldFocused,
                onFocusChanged = { isFocused ->
                    isAnyTextfieldFocused = isFocused
                }
            )
        }
    }
}

@Preview
@Composable
fun ChangePasswordScreenPreview() {
    PreviewTemplateMaxSize {
        ChangePasswordScreen(navController = mockNavController())
    }
}