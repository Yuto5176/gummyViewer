package com.github.yuto5176.gummyviewer.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.yuto5176.gummyviewer.data.model.GummyDetail
import com.github.yuto5176.gummyviewer.data.model.Image
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun HomeScreenCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = "",
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            val list = fetchTask(10000)
            // Log.d("firebase", "list: $list")
        }
    }
}

fun Map<String, Any>.toGummy(): GummyDetail {
    val name = this["name"] as String
    val url = this["image"] as String
    return GummyDetail(title = name, image = Image(url))
}

// suspendにする
fun fetchTask(limit: Long): List<GummyDetail> {
    val db = Firebase.firestore
    return try {
        var gummyList: List<GummyDetail> = emptyList()
        val collection = db.collection("gummyDetail")
        collection.limit(limit).get().addOnSuccessListener {
            //Log.d("firebase", "collection success")
        }.addOnCompleteListener { result ->
            result.result.documents.map { it.data }.mapNotNull {
                gummyList = listOf(it?.toGummy()) as List<GummyDetail>
                //Log.d("firebase", "collection complete")
                //Log.d("firebase", "gummyList: $gummyList")
            }
        }
        //Log.d("firebase", "return")
        gummyList
    } catch (e: Exception) {
        //Log.d("firebase", "Exception")
        emptyList()
    }
}