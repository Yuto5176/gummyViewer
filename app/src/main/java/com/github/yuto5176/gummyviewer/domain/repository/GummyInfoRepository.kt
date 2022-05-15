package com.github.yuto5176.gummyviewer.domain.repository

import com.github.yuto5176.gummyviewer.data.model.GummyDetail
import com.github.yuto5176.gummyviewer.data.service.FirebaseResult
import kotlinx.coroutines.flow.Flow

interface GummyInfoRepository {
    suspend fun fetchData(limit: Long): Flow<List<GummyDetail?>>
}