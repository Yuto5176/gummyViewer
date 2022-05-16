package com.github.yuto5176.gummyviewer.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TopBarComponent(
    onButtonClicked: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Gummy Viewer") },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() }) {
                Icon(
                    imageVector = Icons.Filled.Menu, contentDescription = "Open drawer"
                )
            }
        }
    )
}