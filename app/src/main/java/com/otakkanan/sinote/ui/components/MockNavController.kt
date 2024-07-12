package com.otakkanan.sinote.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun mockNavController(): NavController {
    val navController = rememberNavController()

    return navController
}