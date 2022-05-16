package com.github.yuto5176.gummyviewer.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.yuto5176.gummyviewer.data.model.GummyDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenCard(gummyCards: List<GummyDetail>, navigate:()-> Unit, modifier: Modifier) {
    LazyColumn{
        item{Spacer(modifier = Modifier.padding(top = 60.dp))}
        items(gummyCards.size){
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp)
                    .clickable{navigate()},
                shape =RoundedCornerShape(16.dp)
            ){
                Column(modifier = modifier.fillMaxWidth()){
                    AsyncImage(
                        model = gummyCards[it].image.url,
                        contentDescription = "image",
                        modifier = modifier
                            .fillMaxWidth()
                            .clip(shape =RoundedCornerShape(8.dp))
                    )
                    Text(
                        modifier = modifier.padding(vertical = 20.dp, horizontal = 15.dp),
                        text = gummyCards[it].title
                    )
                }
            }
        }
        item{Spacer(modifier = Modifier.padding(top = 80.dp))}
    }
}