package com.github.yuto5176.gummyviewer.data.repository

import com.github.yuto5176.gummyviewer.data.model.GummyDetail
import com.github.yuto5176.gummyviewer.data.model.Image
import com.github.yuto5176.gummyviewer.data.service.FirebaseResult
import com.github.yuto5176.gummyviewer.domain.repository.GummyInfoRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GummyInfoRepositoryImpl @Inject constructor() : GummyInfoRepository {

    //private var cache: Flow<List<GummyDetail>>? = null

    private fun Map<String, Any>.toGummy(): GummyDetail {
        val seller = this["seller"] as String
        val name = this["name"] as String
        val url = this["image"] as String
        val description = this["description"] as String
        return GummyDetail(seller = seller, title = name, image = Image(url), description = description)
    }

    override suspend fun fetchData(
        limit: Long
    ): Flow<List<GummyDetail?>> {
        return callbackFlow {
            val db = Firebase.firestore
            val collection = db.collection("gummyDetail")
            val snapshotListener = collection.limit(5).addSnapshotListener { value, error ->
                this.trySend(value)
            }
            awaitClose { snapshotListener.remove() }
        }.mapNotNull { it?.documents?.map { it.data?.toGummy() } }
    }

}