package com.otakkanan.sinote.ui.screens.forgotpasswordscreens.createNewPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.AuthForm
import com.otakkanan.sinote.ui.components.AuthFormType
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNewPasswordScreen(navController: NavController) {
    var passwordValue by remember { mutableStateOf("") }
    var repeatPasswordValue by remember { mutableStateOf("") }
//    var hideKeyboard by remember { mutableStateOf(false) }
    var isRememberMe by remember { mutableStateOf(false) }
    var isAnyTextfieldFocused by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        stringResource(id = R.string.buat_kata_sandi),
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
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(if(!isAnyTextfieldFocused) 250.dp else 0.dp),
                painter = painterResource(id = R.drawable.reset_pass_illustration),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )

            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.buat_kata_sandi_desc),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(top = 16.dp)
            )

            AuthForm(
                authFormType = AuthFormType.PASSWORD,
                value = passwordValue,
                onValueChange = {
                    passwordValue = it
                },
                imeAction = ImeAction.Next,
                hideKeyboard = !isAnyTextfieldFocused,
                onFocusChanged = { isFocused ->
                    isAnyTextfieldFocused = isFocused
                },
                modifier = Modifier
                    .padding(top = 16.dp)
            )

            AuthForm(
                authFormType = AuthFormType.REPEAT_PASSWORD,
                value = repeatPasswordValue,
                onValueChange = {
                    repeatPasswordValue = it
                },
                imeAction = ImeAction.Done,
                hideKeyboard = !isAnyTextfieldFocused,
                onFocusChanged = { isFocused ->
                    isAnyTextfieldFocused = isFocused
                },
                modifier = Modifier
                    .padding(top = 16.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Checkbox(
                    checked = isRememberMe,
                    onCheckedChange = { isRememberMe = it },
                    modifier = Modifier
                        .padding(horizontal = 0.dp)
                )
                Text(
                    text = stringResource(id = R.string.ingat_saya),
                    style = Typography.labelLarge
                )
            }

            Button(
                onClick = {
                    navController.navigate("login") {
                        popUpTo("login") {
                            inclusive = true
                        }
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
        }
    }
}

@Preview
@Composable
fun CreateNewPasswordScreenPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            CreateNewPasswordScreen(navController = mockNavController())
        }
    }
}
