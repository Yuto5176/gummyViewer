package com.github.yuto5176.gummyviewer.navigation

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.yuto5176.gummyviewer.components.BottomBarComponent
import com.github.yuto5176.gummyviewer.components.DrawerComponent
import com.github.yuto5176.gummyviewer.components.TopBarComponent
import com.github.yuto5176.gummyviewer.data.model.GummyDetail
import com.github.yuto5176.gummyviewer.data.model.Image
import com.github.yuto5176.gummyviewer.ui.screens.favorite.FavoriteScreen
import com.github.yuto5176.gummyviewer.ui.screens.favorite.FavoriteScreenViewModel
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeDetailScreen
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeDetailScreenViewModel
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeScreen
import com.github.yuto5176.gummyviewer.ui.screens.home.HomeScreenViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(startScreen: String) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val nav = navController.currentBackStackEntryFlow
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
//            TopBarComponent {
//                if (drawerState.isClosed) openDrawer() else closeDrawer()
//            }
        },
        bottomBar = {
            BottomBarComponent(navController = navController)
        },
        content = {
            it
            ModalNavigationDrawer(
                drawerState = drawerState,
                gesturesEnabled = drawerState.isOpen,
                drawerContent = {
                    DrawerComponent()
                }
            ) {
                NavHost(navController = navController, startDestination = startScreen) {
                    composable(route = AppScreen.HomeScreen.route) {
                        val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
                        HomeScreen(
                            navController = navController,
                            viewModel = homeScreenViewModel
                        ) { seller, description, title, imagePath ->
                            navController.navigate("${AppScreen.HomeDetailScreen.route}/${seller}/${description}/${title}/${imagePath}")
                        }
                    }

                    composable(
                        route = "${AppScreen.HomeDetailScreen.route}/{seller}/{description}/{title}/{imagePath}",
                        arguments = listOf(
                            navArgument("seller") { type = NavType.StringType },
                            navArgument("description") { type = NavType.StringType },
                            navArgument("title") { type = NavType.StringType },
                            navArgument("imagePath") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        val homeDetailScreenViewModel = hiltViewModel<HomeDetailScreenViewModel>()
                        val seller = backStackEntry.arguments?.getString("seller") ?: "null"
                        val description =
                            backStackEntry.arguments?.getString("description") ?: "null"
                        val title = backStackEntry.arguments?.getString("title") ?: "null"
                        val imagePath = backStackEntry.arguments?.getString("imagePath")?: "null"
                        HomeDetailScreen(
                            navController = navController,
                            viewModel = homeDetailScreenViewModel,
                            gummyDetail = GummyDetail(
                                seller = seller,
                                description = description,
                                title = title,
                                image = Image(imagePath)
                            )
                        )
                    }

                    composable(route = AppScreen.FavoriteScreen.route) {
                        val favoriteScreenViewModel = hiltViewModel<FavoriteScreenViewModel>()
                        FavoriteScreen(
                            navController = navController,
                            viewModel = favoriteScreenViewModel
                        )
                    }
                }
            }
        }
    )
}