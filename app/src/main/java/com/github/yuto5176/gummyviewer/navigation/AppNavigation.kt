package com.github.yuto5176.gummyviewer.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.yuto5176.gummyviewer.components.BottomBarComponent
import com.github.yuto5176.gummyviewer.components.DrawerComponent
import com.github.yuto5176.gummyviewer.components.TopBarComponent
import com.github.yuto5176.gummyviewer.ui.screens.favorite.FavoriteScreen
import com.github.yuto5176.gummyviewer.ui.screens.favorite.FavoriteScreenViewModel
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeDetailScreen
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeDetailScreenViewModel
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeScreen
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(startScreen: String) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val openDrawer = {
        scope.launch {
            scaffoldState.drawerState.apply {
                drawerState.open()
            }
        }
    }
    val closeDrawer = {
        scope.launch {
            scaffoldState.drawerState.apply {
                drawerState.close()
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarComponent {
                if (drawerState.isClosed) openDrawer() else closeDrawer()
            }
        },
        bottomBar = {
            BottomBarComponent(navController = navController)
        }
    ) {
        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                DrawerComponent()
            }
        ) {
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
    }
}