package com.otakkanan.sinote.ui.components.tugas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.otakkanan.sinote.ui.theme.color_primary2_700

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateBottomSheet(
    title: String,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit,
    optionList: List<String>
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(top = 8.dp, bottom = 16.dp)
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(title, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                Text("Selesai", fontWeight = FontWeight.SemiBold, color = color_primary2_700)

            }
            Spacer(modifier = Modifier.height(16.dp))
            optionList.forEach { item ->
                ReminderOption(
                    text = item,
                    isSelected = item == selectedOption,
                    onSelect = { onOptionSelected(item) }
                )
            }
        }
    }
}

@Composable
fun ReminderOption(text: String, isSelected: Boolean, onSelect: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
            .clickable { onSelect() }
    ) {
        Text(text, modifier = Modifier.weight(1f))
        Checkbox(
            checked = isSelected,
            onCheckedChange = { onSelect() }
        )
    }
}