package com.otakkanan.sinote.ui.components.tugas

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.otakkanan.sinote.ui.theme.color_primary2_300
import com.otakkanan.sinote.ui.theme.color_primary2_700
import com.otakkanan.sinote.ui.theme.color_tugas_textfield


@Composable
fun SubTugasTextField(
    value: String = "",
    placeholder: String = "Masukkan sub-tugas",
    onValueChange: (String) -> Unit = {},
    imeAction: ImeAction = ImeAction.Done,
) {
    Column() {
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(color = color_tugas_textfield, shape = CircleShape)
                    .border(width = 1.dp, color = color_primary2_300, shape = CircleShape)
            )
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp)
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = MaterialTheme.typography.bodyMedium.copy(color = color_primary2_300),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                        innerTextField()
                    }
                },
                textStyle = MaterialTheme.typography.bodyMedium.copy(color = color_primary2_700),
            )
        }
    }
}