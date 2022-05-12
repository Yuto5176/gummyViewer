package com.github.yuto5176.gummyviewer.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.github.yuto5176.gummyviewer.navigation.AppScreen

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel,
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "home")
            Button(
                modifier = Modifier.padding(vertical = 50.dp),
                onClick = {
                    navController.navigate(AppScreen.HomeDetailScreen.route)
                }
            ){
                Text(text = "to detail")
            }
            HomeScreenCard()
        }
    }
}
//
//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun GridView(photos: List<Photo>){
//    LazyVerticalGrid(
//        cells = GridCells.Fixed(2)
//    ){
//        items(photos){ photo ->
//            PhotoItem(photo)
//        }
//    }
//}
