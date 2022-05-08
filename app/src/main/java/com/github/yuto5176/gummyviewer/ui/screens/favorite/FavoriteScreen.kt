package com.github.yuto5176.gummyviewer.ui.screens.favorite

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun FavoriteScreen(
    navController: NavController,
    viewModel: FavoriteScreenViewModel,
) {
    Text(text = "Favorite")
}