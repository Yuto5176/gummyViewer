package com.github.yuto5176.gummyviewer.data.model

import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

sealed class FirebaseResult
    data class Success(val querySnapshot: QuerySnapshot?) : FirebaseResult()
    data class Error(val exception: Throwable) : FirebaseResult()


//object Proceeding: FirebaseResult<Nothing>()
