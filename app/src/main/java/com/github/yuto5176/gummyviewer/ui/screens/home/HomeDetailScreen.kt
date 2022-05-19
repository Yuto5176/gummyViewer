package com.github.yuto5176.gummyviewer.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.github.yuto5176.gummyviewer.data.model.GummyDetail

@Composable
fun HomeDetailScreen(
    navController: NavController,
    viewModel: HomeDetailScreenViewModel,
    gummyDetail: GummyDetail
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "detail")
        Text(text = gummyDetail.seller)
        Text(text = gummyDetail.description)
        Text(text = gummyDetail.title)
        Text(text = gummyDetail.image.url)
    }
}