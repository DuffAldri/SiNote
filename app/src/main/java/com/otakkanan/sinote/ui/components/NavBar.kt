package com.otakkanan.sinote.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_white

sealed class BottomNavItem(
    val title: String,
    val activeIcon: Int,
    val inactiveIcon: Int
) {
    object Catatan :
        BottomNavItem(
        title = "Catatan",
        activeIcon = R.drawable.catatan_navbar_active,
        inactiveIcon = R.drawable.catatan_navbar_inactive
    )
    object Tugas :
        BottomNavItem(
        title = "Tugas",
        activeIcon = R.drawable.tugas_navbar_active,
        inactiveIcon = R.drawable.tugas_navbar_inactive)
    object Inspirasi :
        BottomNavItem(
        title = "Inspirasi",
        activeIcon = R.drawable.inspirasi_navbar_active,
        inactiveIcon = R.drawable.inspirasi_navbar_inactive)
    object Profil :
        BottomNavItem(
        title = "Profil",
        activeIcon = R.drawable.profil_navbar_active,
        inactiveIcon = R.drawable.profil_navbar_inactive)
}

@Composable
fun NavBar(

) {
    NavigationBar(
        containerColor = color_white,
    ) {

        val items = listOf(
            BottomNavItem.Catatan,
            BottomNavItem.Tugas,
            BottomNavItem.Inspirasi,
            BottomNavItem.Profil
        )

        NavigationBar {
            items.forEach { item ->
                AddItem(
                    screen = item
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem
) {
    NavigationBarItem(
        // Text that shows bellow the icon
        label = {
            Text(text = screen.title)
        },

        // The icon resource
        icon = {
            Image(
                painterResource(id = screen.activeIcon),
                contentDescription = screen.title
            )
        },

        // Display if the icon it is select or not
        selected = true,

        // Always show the label bellow the icon or not
        alwaysShowLabel = true,

        // Click listener for the icon
        onClick = { /*TODO*/ },

        // Control all the colors of the icon
        colors = NavigationBarItemDefaults.colors()
    )
}

@Preview
@Composable
fun NavBarPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NavBar()
        }
    }
}