package com.github.yuto5176.gummyviewer.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerComponent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 90.dp)
    ) {
        Text(text = "drawer")

    }
}