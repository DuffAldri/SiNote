package com.otakkanan.sinote.ui.screens.registerscreens.register

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.AuthForm
import com.otakkanan.sinote.ui.components.AuthFormType
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.theme.Typography
import com.otakkanan.sinote.ui.theme.color_primary2_700
import com.otakkanan.sinote.ui.theme.color_primary_600

@Composable
fun RegisterScreen(navController: NavController) {
    var hideKeyboard by remember { mutableStateOf(false) }
    var isAnyTextfieldFocused by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick =  {
//                    hideKeyboard = true
                    isAnyTextfieldFocused = false
                }
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var nameValue by remember { mutableStateOf("") }
        var emailValue by remember { mutableStateOf("") }
        var passwordValue by remember { mutableStateOf("") }

        Image(
            painter = painterResource(id = R.drawable.logo_ok),
            contentDescription = stringResource(id = R.string.app_logo),
            modifier = Modifier
                .padding(top = 32.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(100.dp),
        )

        Text(
            text = stringResource(id = R.string.daftar).uppercase(),
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        AuthForm(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp),
            authFormType = AuthFormType.NAME,
            value = nameValue,
            onValueChange = { nameValue = it },
            imeAction = ImeAction.Next,
//            hideKeyboard = hideKeyboard,
//            onFocusClear = { hideKeyboard = false }
            hideKeyboard = !isAnyTextfieldFocused,
            onFocusChanged = { isFocused ->
                isAnyTextfieldFocused = isFocused
            },
        )

        AuthForm(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp),
            authFormType = AuthFormType.EMAIL,
            value = emailValue,
            onValueChange = { emailValue = it },
            imeAction = ImeAction.Next,
//            hideKeyboard = hideKeyboard,
//            onFocusClear = { hideKeyboard = false }
            hideKeyboard = !isAnyTextfieldFocused,
            onFocusChanged = { isFocused ->
                isAnyTextfieldFocused = isFocused
            },
        )

        AuthForm(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 4.dp, bottom = 16.dp),
            authFormType = AuthFormType.PASSWORD,
            value = passwordValue,
            onValueChange = { passwordValue = it },
            imeAction = ImeAction.Done,
//            hideKeyboard = hideKeyboard,
//            onFocusClear = { hideKeyboard = false }
            hideKeyboard = !isAnyTextfieldFocused,
            onFocusChanged = { isFocused ->
                isAnyTextfieldFocused = isFocused
            },
        )

        Button(
            onClick = {navController.navigate("tugas")},
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .height(IntrinsicSize.Max)
                .fillMaxWidth(),
        ) {
            Text(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                text = stringResource(id = R.string.daftar),
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 16.dp)
        ) {
            Divider(
                modifier = Modifier
                    .width(40.dp),
            )
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.atau_daftar_dengan),
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            Divider(
                modifier = Modifier
                    .width(40.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedButton(
                onClick = {navController.navigate("tugas")},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(50.dp)
                    .width(70.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.google_logo),
                    contentDescription = null,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
            OutlinedButton(
                onClick = {navController.navigate("tugas")},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(50.dp)
                    .width(70.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.facebook_logo),
                    contentDescription = null,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
            OutlinedButton(
                onClick = {navController.navigate("tugas")},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(50.dp)
                    .width(70.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.apple_logo),
                    contentDescription = null,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.sudah_punya_akun),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(end = 8.dp)
            )
            ClickableText(text = AnnotatedString(stringResource(id = R.string.masuk)), style = Typography.labelLarge.copy(color = color_primary_600)) {
                navController.navigate("login")
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            RegisterScreen(navController = mockNavController())
        }
    }
}