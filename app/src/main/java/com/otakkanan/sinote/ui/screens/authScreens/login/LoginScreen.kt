package com.otakkanan.sinote.ui.screens.authScreens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
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
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.AuthForm
import com.otakkanan.sinote.ui.components.AuthFormType
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.Typography
import com.otakkanan.sinote.ui.theme.color_primary2_700
import com.otakkanan.sinote.ui.theme.color_primary_600

@Composable
fun LoginScreen(navController: NavController) {
    var isAnyTextfieldFocused by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = scrollState)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick =  {
//                    hideKeyboard = true
                    isAnyTextfieldFocused = false
                }
            )
            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var emailValue by remember { mutableStateOf("") }
        var passwordValue by remember { mutableStateOf("") }
        var isRememberMe by remember { mutableStateOf(false) }

        Image(
            painter = painterResource(id = R.drawable.logo_ok),
            contentDescription = stringResource(id = R.string.app_logo),
            modifier = Modifier
                .padding(top = 32.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(100.dp),
        )

        Text(
            text = stringResource(id = R.string.masuk).uppercase(),
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            color = color_primary2_700,
            modifier = Modifier
                .padding(bottom = 16.dp)
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

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(start = 8.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
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

            ClickableText(text = AnnotatedString(
                stringResource(id = R.string.lupa_kata_sandi)),
                style = Typography.labelLarge,
                onClick = {navController.navigate("forgot_password_route")}
            )

        }

        Button(
            onClick = {navController.navigate("catatan_route")},
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .height(IntrinsicSize.Max)
                .fillMaxWidth(),
        ) {
            Text(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                text = stringResource(id = R.string.masuk),
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
                text = stringResource(id = R.string.atau_masuk_dengan),
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
                onClick = {navController.navigate("catatan_route")},
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
                onClick = {navController.navigate("catatan_route")},
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
                onClick = {navController.navigate("catatan_route")},
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
                text = stringResource(id = R.string.belum_punya_akun),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(end = 8.dp)
            )
            ClickableText(text = AnnotatedString(stringResource(id = R.string.daftar)), style = Typography.labelLarge.copy(color = color_primary_600)) {
                navController.navigate("register")
            }
        }


    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LoginScreen(navController = mockNavController())
        }
    }
}
