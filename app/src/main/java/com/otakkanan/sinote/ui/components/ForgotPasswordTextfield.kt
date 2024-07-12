package com.otakkanan.sinote.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otakkanan.sinote.ui.screens.forgotpasswordscreens.forgotPassword.ForgotPasswordScreen
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.theme.color_primary_200
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordTextfield(
    value: String,
    onValueChange: (String) -> Unit,
    hideKeyboard: Boolean = false,
    onFocusChanged: (Boolean) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var isFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = modifier
            .border(
                BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(5.dp)
            )
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Min)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(color = color_primary_200, shape = RoundedCornerShape(8.dp))
                    .padding(12.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.sms_tracking), contentDescription = "")
            }
//            Spacer(
//                Modifier.width(16.dp)
//            )
            TextField(
                value = value,
                onValueChange = onValueChange,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onBackground
                ),
                label = { Text("Email")},
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                singleLine = true,
                modifier = Modifier
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                        onFocusChanged(isFocused)
//                    Log.d("FocusChange", "isFocused = " + isFocused + " " + authFormType.title)
                    }
            )
        }
    }

    if (hideKeyboard) {
        focusManager.clearFocus()
//        Log.d("FocusChange", "hideKeyboard = " + hideKeyboard + " " + authFormType.title)

    }
}

@Preview
@Composable
fun ForgotPasswordTextfieldPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ForgotPasswordTextfield("", {})
        }
    }
}