package com.otakkanan.sinote.ui.components.tugas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.otakkanan.sinote.ui.theme.color_primary2_300
import com.otakkanan.sinote.ui.theme.color_primary_600

@Composable
fun CategorySelector(modifier: Modifier = Modifier) {
    var selectedOption by remember { mutableStateOf("Kelompok") }  // Default selection
    val options = listOf("Personal", "Kelompok")

    Column(modifier = modifier) {
        options.forEach { option ->
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = (selectedOption == option),
                    onClick = { selectedOption = option },
                    colors = RadioButtonDefaults.colors(selectedColor = color_primary_600),
                    modifier = Modifier
                        .size(20.dp)
                        .padding(start = 6.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = option,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if(selectedOption == option) color_primary_600 else color_primary2_300,
                )
            }
        }
    }
}