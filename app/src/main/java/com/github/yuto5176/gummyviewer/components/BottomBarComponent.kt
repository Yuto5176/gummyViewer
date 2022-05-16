package com.github.yuto5176.gummyviewer.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.github.yuto5176.gummyviewer.navigation.AppScreen

//TODO var
sealed class BottomBarItem(var dist: String, var icon: ImageVector, var screenRoute: String) {
    object Home : BottomBarItem("Home", Icons.Default.Home, AppScreen.HomeScreen.route)
    object Favorite : BottomBarItem("Favorite", Icons.Default.Star, AppScreen.FavoriteScreen.route)
}

@Composable
fun BottomBarComponent(
    navController: NavController,
) {
    val items = listOf(
        BottomBarItem.Home,
        BottomBarItem.Favorite
    )
    var selectedItem = remember { mutableStateOf(0) }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(imageVector = item.icon,
                        contentDescription = "BottomNavIcon")
                },
                label = { Text(item.dist) },
                selected = selectedItem.value == index,
                onClick = {
                    selectedItem.value = index
                    navController.navigate(item.screenRoute)
                }
            )
        }
    }
}