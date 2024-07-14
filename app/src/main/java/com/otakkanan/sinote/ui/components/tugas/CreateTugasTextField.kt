package com.otakkanan.sinote.ui.components.tugas

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.otakkanan.sinote.ui.theme.color_primary2_300
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_textfield
import com.otakkanan.sinote.ui.theme.color_white

@Composable
fun CreateTugasTextField(
    value: String = "",
    placeholder: String = "",
    onValueChange: (String) -> Unit = {},
    imeAction: ImeAction = ImeAction.Default,
    hideKeyboard: Boolean = false,
    onFocusChanged: (Boolean) -> Unit = {},
    minLines: Int = 1
) {
    var isFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                placeholder,
                fontSize = 14.sp,
                color = color_primary2_300,
                overflow = TextOverflow.Ellipsis
            )
        },
        shape = RoundedCornerShape(5.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = color_textfield,
            focusedBorderColor = color_primary_600,
            unfocusedContainerColor = color_textfield,
            focusedContainerColor = color_white
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction
        ),
        minLines = minLines,
        modifier = Modifier
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
                onFocusChanged(isFocused)
            }
            .fillMaxWidth()
    )

    if (hideKeyboard) {
        focusManager.clearFocus()
    }
}