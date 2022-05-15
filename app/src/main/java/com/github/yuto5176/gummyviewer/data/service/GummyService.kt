package com.github.yuto5176.gummyviewer.data.service

import com.google.firebase.firestore.FirebaseFirestoreException

sealed class FirebaseResult<out T> {
    object Proceeding : FirebaseResult<Nothing>()
    data class Success<out T>(val data: T) : FirebaseResult<T>()
    data class Error(val exception: FirebaseFirestoreException?) : FirebaseResult<Nothing>()
}

