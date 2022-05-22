package com.github.yuto5176.gummyviewer.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.github.yuto5176.gummyviewer.data.model.GummyDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeDetailScreen(
    navController: NavController,
    viewModel: HomeDetailScreenViewModel,
    gummyDetail: GummyDetail
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            AsyncImage(
                model = gummyDetail.image.url,
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(top = 30.dp, start = 25.dp, end = 25.dp),
                    text = gummyDetail.title,
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    modifier = Modifier.padding(top = 15.dp, start = 25.dp, end = 25.dp),
                    text = gummyDetail.seller,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    modifier = Modifier.padding(top = 50.dp, start = 25.dp, end = 25.dp),
                    text = "About",
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    modifier = Modifier.padding(top = 15.dp, start = 25.dp, end = 25.dp),
                    text = gummyDetail.description,
                    style = MaterialTheme.typography.bodySmall
                )

            }

        }
    }
    Button(
        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
        onClick = { navController.popBackStack() }
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
    }
}