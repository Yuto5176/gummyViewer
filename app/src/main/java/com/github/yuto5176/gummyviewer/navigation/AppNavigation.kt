package com.github.yuto5176.gummyviewer.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.yuto5176.gummyviewer.components.BottomBarComponent
import com.github.yuto5176.gummyviewer.components.TopBarComponent
import com.github.yuto5176.gummyviewer.ui.screens.favorite.FavoriteScreen
import com.github.yuto5176.gummyviewer.ui.screens.favorite.FavoriteScreenViewModel
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeDetailScreen
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeDetailScreenViewModel
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeScreen
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeScreenViewModel

@Composable
fun AppNavigation(startScreen: String) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarComponent()
        },
        bottomBar = {
            BottomBarComponent(navController = navController)
        },
        content = {
            NavHost(navController = navController, startDestination = startScreen) {
                composable(route = AppScreen.HomeScreen.route) {
                    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
                    HomeScreen(navController = navController, viewModel = homeScreenViewModel)
                }

                composable(route = AppScreen.HomeDetailScreen.route) {
                    val homeDetailScreenViewModel = hiltViewModel<HomeDetailScreenViewModel>()
                    HomeDetailScreen(navController = navController,
                        viewModel = homeDetailScreenViewModel)
                }

                composable(route = AppScreen.FavoriteScreen.route) {
                    val favoriteScreenViewModel = hiltViewModel<FavoriteScreenViewModel>()
                    FavoriteScreen(navController = navController,
                        viewModel = favoriteScreenViewModel)
                }
            }
        }
    )
}