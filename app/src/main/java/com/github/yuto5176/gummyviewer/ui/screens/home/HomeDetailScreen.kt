package com.github.yuto5176.gummyviewer.ui.screens.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeDetailScreen(
    navController: NavController,
    viewModel: HomeDetailScreenViewModel,
) {
    Text(text = "homeDetail")
}