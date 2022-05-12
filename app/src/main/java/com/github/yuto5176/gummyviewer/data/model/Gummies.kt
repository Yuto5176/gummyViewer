package com.github.yuto5176.gummyviewer.data.model

data class Gummies(
    val gummiesDetail: List<GummyDetail>,
)

data class GummyDetail(
    val id: String = "",
    val title: String,
    val image: Image,
)

data class Image(
    val url: String,
)
