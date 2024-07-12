package com.otakkanan.sinote.ui.components.tugas

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.theme.color_white

@Composable
fun DropDownButton(
    selectedKategori: String,
    onKategoriSelected: (String) -> Unit,
    isKategoriExpanded: Boolean,
    onKategoriExpandedChange: (Boolean) -> Unit,
    kategoriItems: List<String>
) {
    Button(
        onClick = { onKategoriExpandedChange(!isKategoriExpanded) },
        modifier = Modifier
    ) {

        Text(
            text = if (selectedKategori == "") "Kategori" else selectedKategori,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
        Icon(
            painter = painterResource(id = R.drawable.arrow___down_2),
            tint = color_white,
            contentDescription = if (isKategoriExpanded) "Collapse" else "Expand",
            modifier = Modifier
                .padding(start = 4.dp)
                .size(20.dp)
        )
        DropdownMenu(
            expanded = isKategoriExpanded,
            onDismissRequest = { onKategoriExpandedChange(false) }
        ) {
            kategoriItems.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        onKategoriSelected(item)
                        onKategoriExpandedChange(false)
                    },
                    text = { Text(item) }
                )
            }
        }
    }
}