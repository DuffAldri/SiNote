package com.otakkanan.sinote.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.otakkanan.sinote.ui.theme.SiNoteTheme

@Composable
fun PreviewTemplateMaxWidth(
    element: @Composable () -> Unit
) {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            element()
        }
    }
}

@Composable
fun PreviewTemplateMaxSize(
    element: @Composable () -> Unit
) {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            element()
        }
    }
}