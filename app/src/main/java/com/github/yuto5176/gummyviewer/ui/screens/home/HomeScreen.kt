package com.github.yuto5176.gummyviewer.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel,
    onClickButton: (String, String, String, String) -> Unit = { _, _, _, _ -> }
) {
    val gummyCards by viewModel.gummyCards.collectAsState()
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeScreenCard(gummyCards = gummyCards, modifier = Modifier, onClickButton = onClickButton)
        }
    }
}
