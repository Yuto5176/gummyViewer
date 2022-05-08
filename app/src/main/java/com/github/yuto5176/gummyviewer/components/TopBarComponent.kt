package com.github.yuto5176.gummyviewer.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBarComponent(
    onButtonClicked: () -> Unit,
) {
    TopAppBar(
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