package com.github.yuto5176.gummyviewer.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.github.yuto5176.gummyviewer.data.model.GummyDetail
import com.github.yuto5176.gummyviewer.data.model.Image
import com.github.yuto5176.gummyviewer.navigation.AppScreen
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun HomeScreenCard(gummyCards: List<GummyDetail>, navigate: () -> Unit, modifier: Modifier) {
    LazyColumn {
        items(gummyCards.size) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable { navigate() },
                shape = RoundedCornerShape(12.dp),
                elevation = 4.dp
            ) {
                Column(modifier = modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = gummyCards[it].image.url,
                        contentDescription = "image",
                        modifier = modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                    Text(text = gummyCards[it].title)
                }
            }
        }
    }
}

