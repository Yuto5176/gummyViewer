package com.github.yuto5176.gummyviewer.navigation

sealed class AppScreen(val route: String) {
    object HomeScreen : AppScreen("home_screen")
    object HomeDetailScreen: AppScreen("homeDetailScreen")
    object FavoriteScreen: AppScreen("favoriteScreen")
}