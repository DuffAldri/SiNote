package com.otakkanan.sinote.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.otakkanan.sinote.ui.theme.color_primary_600

@Composable
fun AddFab(onClick: () -> Unit) {
    FloatingActionButton(
        modifier = Modifier
            .size(48.dp),
        containerColor = color_primary_600,
        shape = RoundedCornerShape(8.dp),
        onClick = {onClick()}
    ) {
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(8.dp))
                .size(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Task", tint = Color.White, modifier = Modifier.size(16.dp))
        }
    }
}