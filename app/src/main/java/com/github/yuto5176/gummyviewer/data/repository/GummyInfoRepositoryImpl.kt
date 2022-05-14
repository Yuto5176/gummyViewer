package com.github.yuto5176.gummyviewer.data.repository

import android.util.Log
import com.github.yuto5176.gummyviewer.data.model.GummyDetail
import com.github.yuto5176.gummyviewer.data.model.Image
import com.github.yuto5176.gummyviewer.domain.repository.GummyInfoRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.okhttp.Dispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

class GummyInfoRepositoryImpl @Inject constructor() : GummyInfoRepository {

    private var cache: Flow<List<GummyDetail>>? = null

    private fun Map<String, Any>.toGummy(): GummyDetail {
        val name = this["name"] as String
        val url = this["image"] as String
        return GummyDetail(title = name, image = Image(url))
    }

    override suspend fun fetchData(limit: Long): Flow<List<GummyDetail>> = flow {
        val db = Firebase.firestore
        var gummyList: List<GummyDetail> = emptyList()
        val collection = db.collection("gummyDetail")
        collection.limit(limit).get().addOnSuccessListener {
        }.addOnCompleteListener { result ->
            result.result.documents.map { it.data }.mapNotNull {
                gummyList = listOf(it?.toGummy()) as List<GummyDetail>
                Log.d("firebase", gummyList.toString())
            }
        }
        delay(1000L)
        emit(gummyList)

    }.flowOn(Dispatchers.Default).also {
        cache = it
    }
}