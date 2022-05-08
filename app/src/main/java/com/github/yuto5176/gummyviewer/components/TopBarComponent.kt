package com.github.yuto5176.gummyviewer.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBarComponent(
    onButtonClicked: () -> Unit
) {
    TopAppBar(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.height(32.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(72.dp - 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { onButtonClicked() }) {
                    Icon(
                        imageVector = Icons.Default.FormatAlignCenter,
                        contentDescription = "Format Align Center Button"
                    )
                }
            }
        }
    }
}