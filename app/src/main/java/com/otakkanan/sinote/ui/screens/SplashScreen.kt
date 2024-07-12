package com.otakkanan.sinote.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.otakkanan.sinote.ui.theme.SiNoteTheme

@Composable
fun SplashScreen() {

}

@Preview
@Composable
fun SplashScreenPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            SplashScreen()
        }
    }
}