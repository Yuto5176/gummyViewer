package com.github.yuto5176.gummyviewer.data.repository

import com.github.yuto5176.gummyviewer.data.model.GummyDetail
import com.github.yuto5176.gummyviewer.data.model.Image
import com.github.yuto5176.gummyviewer.data.service.FirebaseResult
import com.github.yuto5176.gummyviewer.domain.repository.GummyInfoRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GummyInfoRepositoryImpl @Inject constructor() : GummyInfoRepository {

    //private var cache: Flow<List<GummyDetail>>? = null

    private fun Map<String, Any>.toGummy(): GummyDetail {
        val name = this["name"] as String
        val url = this["image"] as String
        return GummyDetail(title = name, image = Image(url))
    }

    override suspend fun fetchData(limit: Long): Flow<FirebaseResult<List<GummyDetail>>> = flow {
        val db = Firebase.firestore
        val collection = db.collection("gummyDetail")
        val snapshotListener = collection.limit(5).addSnapshotListener { value, error ->
            val response = if (error == null) {
                FirebaseResult.Success(value)
            } else {
                FirebaseResult.Error(error)
            }
        }
    } .catch { e: Throwable ->
        //emit(FirebaseResult.Error(e))
    }
//        .flowOn(Dispatchers.Default).also {
//        cache = it
//    }

//    inline fun apiFlow(crossinline call: suspend () -> Flow<QuerySnapshot>) =
//        callbackFlow {
//            val db = Firebase.firestore
//            val collection = db.collection("gummyDetail")
//            val snapshotListener = collection.limit(5).addSnapshotListener { value, error ->
//                val response = if (error == null) {
//                    FirebaseResult.Success(value)
//                } else {
//                    FirebaseResult.Error(error)
//                }
//                this.trySend(response).isSuccess
//            }
//
//            awaitClose { snapshotListener.remove() }
//        }


    //        val db = Firebase.firestore
//        var gummyList: List<GummyDetail> = emptyList()
//        val collection = db.collection("gummyDetail")
//        collection.limit(limit).get().addOnSuccessListener {
//        }.addOnCompleteListener { result ->
//            result.result.documents.map { it.data }.mapNotNull {
//                gummyList = listOf(it?.toGummy()) as List<GummyDetail>
//                Log.d("firebase", gummyList.toString())
//            }
//        }
//        delay(1000L)
//        emit(gummyList)
}