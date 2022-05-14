package com.github.yuto5176.gummyviewer.data.service

import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

sealed class FirebaseResult<out T> {
    object Proceeding : FirebaseResult<Nothing>()
    data class Success<out T>(val data: T) : FirebaseResult<T>()
    data class Error(val exception: FirebaseFirestoreException?) : FirebaseResult<Nothing>()
}

inline fun <reified T : Any> apiFlow(crossinline call: suspend () -> Flow<QuerySnapshot>) =
    callbackFlow {
        val db = Firebase.firestore
        val collection = db.collection("gummyDetail")
        val snapshotListener = collection.limit(5).addSnapshotListener { value, error ->
            val response = if (error == null) {
                FirebaseResult.Success(value)
            } else {
                FirebaseResult.Error(error)
            }
            this.trySend(response).isSuccess
        }

        awaitClose { snapshotListener.remove() }
    }