package com.otakkanan.sinote.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.navigations.Screen
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_primary2_50
import com.otakkanan.sinote.ui.theme.color_primary2_800
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_white

sealed class BottomNavItem(
    val title: String,
    val activeIcon: Int,
    val inactiveIcon: Int,
    val screen: Screen
) {
    object Catatan : BottomNavItem(
        title = "Catatan",
        activeIcon = R.drawable.catatan_navbar_active,
        inactiveIcon = R.drawable.catatan_navbar_inactive,
        screen = Screen.CatatanList
    )
    object Tugas : BottomNavItem(
        title = "Tugas",
        activeIcon = R.drawable.tugas_navbar_active,
        inactiveIcon = R.drawable.tugas_navbar_inactive,
        screen = Screen.TugasList
    )
    object Inspirasi : BottomNavItem(
        title = "Inspirasi",
        activeIcon = R.drawable.inspirasi_navbar_active,
        inactiveIcon = R.drawable.inspirasi_navbar_inactive,
        screen = Screen.InspirasiList
    )
    object Profil : BottomNavItem(
        title = "Profil",
        activeIcon = R.drawable.profil_navbar_active,
        inactiveIcon = R.drawable.profil_navbar_inactive,
        screen = Screen.Profil
    )
}



@Composable
fun NavBar(
    navController: NavController
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val items = listOf(
        BottomNavItem.Catatan,
        BottomNavItem.Tugas,
        BottomNavItem.Inspirasi,
        BottomNavItem.Profil
    )

    NavigationBar(
        containerColor = color_primary2_50,
        tonalElevation = 1.dp,
        modifier = Modifier
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                shadowElevation = 30f
                ambientShadowColor = color_primary2_800
            }
    )  {
        items.forEach { item ->
            AddItem(
                bottomNavItem = item,
                navController = navController,
                isCurrentRoute = item.screen.route == currentRoute
            )
        }
    }

}

@Composable
fun RowScope.AddItem(
    bottomNavItem: BottomNavItem,
    navController: NavController,
    isCurrentRoute: Boolean
) {
    NavigationBarItem(
        // Text that shows bellow the iconw
        label = {
            if(isCurrentRoute)
                Text(text = bottomNavItem.title, color = color_primary_600)
            else
                Text(text = bottomNavItem.title)
        },

        // The icon resource
        icon = {
            Image(
                painterResource(id = if(isCurrentRoute) bottomNavItem.activeIcon else bottomNavItem.inactiveIcon),
                contentDescription = bottomNavItem.title
            )
        },

        // Display if the icon it is select or not
        selected = false,

        // Always show the label bellow the icon or not
        alwaysShowLabel = true,

        // Click listener for the icon
        onClick = {
            navController.navigate(bottomNavItem.screen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },

        // Control all the colors of the icon
        colors = NavigationBarItemDefaults.colors(

        )
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
            Scaffold(
                bottomBar = { NavBar(mockNavController()) }
            ) {

            }
        }
    }
}