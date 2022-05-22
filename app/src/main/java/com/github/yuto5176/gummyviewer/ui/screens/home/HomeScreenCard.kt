package com.github.yuto5176.gummyviewer.ui.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.yuto5176.gummyviewer.data.model.GummyDetail
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenCard(
    gummyCards: List<GummyDetail>,
    modifier: Modifier,
    onClickButton: (String, String, String, String) -> Unit = { _, _, _, _ -> }
) {
    LazyColumn {
        item {
            Column(
                modifier = modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier.padding(10.dp),
                    text = "Gummy Viewer",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
        item {
            gummyCards.forEach {
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp)
                        .clickable {
                            onClickButton(
                                it.seller,
                                it.description,
                                it.title,
                                URLEncoder.encode(it.image.url, StandardCharsets.UTF_8.toString())
                            )
                        },
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = modifier.fillMaxWidth()) {
                        AsyncImage(
                            model = it.image.url,
                            contentDescription = "image",
                            modifier = modifier
                                .fillMaxWidth()
                        )
                        Text(
                            modifier = modifier.padding(vertical = 20.dp, horizontal = 25.dp),
                            text = it.title,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
        item { Spacer(modifier = Modifier.padding(top = 80.dp)) }
    }
}