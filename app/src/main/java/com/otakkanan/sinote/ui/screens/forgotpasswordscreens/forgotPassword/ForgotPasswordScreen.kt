package com.otakkanan.sinote.ui.screens.forgotpasswordscreens.forgotPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.ForgotPasswordTextfield
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.theme.SiNoteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(navController: NavController) {
    var emailValue by remember { mutableStateOf("") }
    var isAnyTextfieldFocused by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { },
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
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(state = scrollState)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(id = R.drawable.fingerprint_illustration),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )

            Text(
                text = stringResource(id = R.string.lupa_kata_sandi_title),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth()
            )

            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.forgot_password_desc),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
            )

            Spacer(
                modifier = Modifier
                .height(32.dp)
            )

            ForgotPasswordTextfield(
                value = emailValue,
                onValueChange = { emailValue = it },
                hideKeyboard = !isAnyTextfieldFocused,
                onFocusChanged = { isFocused ->
                    isAnyTextfieldFocused = isFocused
                },
            )

            Button(
                onClick = {navController.navigate("email_verification")},
                shape = RoundedCornerShape(16.dp),
                enabled = emailValue != "",
                modifier = Modifier
                    .padding(vertical = 16.dp)
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
        }
    }
}

@Preview
@Composable
fun ForgotPasswordScreenPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ForgotPasswordScreen(navController = mockNavController())
        }
    }
}