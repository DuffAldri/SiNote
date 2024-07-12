package com.otakkanan.sinote.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_form_bg
import com.otakkanan.sinote.ui.theme.color_primary2_200
import com.otakkanan.sinote.ui.theme.color_primary2_300
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthForm(
    modifier: Modifier = Modifier,
    authFormType: AuthFormType,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,
    imeAction: ImeAction = ImeAction.Done,
    hideKeyboard: Boolean = false,
    onFocusChanged: (Boolean) -> Unit = {},
) {
    var isFocused by remember { mutableStateOf(false) }
    var isPasswordVisible by remember {mutableStateOf(false)}
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
    ) {
        Text(
            text = authFormType.title,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            leadingIcon = {
                          Icon(painter = painterResource(id = authFormType.leadingIconId), contentDescription = null, modifier = Modifier.height(18.dp))
            },
            trailingIcon = {
                    if (authFormType == AuthFormType.PASSWORD || authFormType == AuthFormType.REPEAT_PASSWORD) {
                        Icon(
                            painter = painterResource(id = R.drawable.show_password_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .height(18.dp)
                                .clickable {
                                    isPasswordVisible = !isPasswordVisible
                                }
                        )
                    }
            },
            placeholder = {
                Text(
                    authFormType.placeholder,
                    fontSize = 16.sp,
                    color = color_primary2_300,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            shape = RoundedCornerShape(20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = color_primary2_200,
                focusedBorderColor = color_primary_600,
            ),
            visualTransformation = if(!isPasswordVisible && (authFormType == AuthFormType.PASSWORD || authFormType == AuthFormType.REPEAT_PASSWORD)) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = authFormType.keyboardType,
                imeAction = imeAction,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            modifier = Modifier
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                    onFocusChanged(isFocused)
//                    Log.d("FocusChange", "isFocused = " + isFocused + " " + authFormType.title)
                }
                .background(
                    color = if(isFocused) color_white else color_form_bg,
                    shape = RoundedCornerShape(20.dp)
                )
                .fillMaxWidth()
        )
    }

    if (hideKeyboard) {
        focusManager.clearFocus()
//        Log.d("FocusChange", "hideKeyboard = " + hideKeyboard + " " + authFormType.title)

    }

}

@Preview
@Composable
fun AuthFormPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AuthForm(
                authFormType = AuthFormType.PASSWORD
            )
        }
    }
}
