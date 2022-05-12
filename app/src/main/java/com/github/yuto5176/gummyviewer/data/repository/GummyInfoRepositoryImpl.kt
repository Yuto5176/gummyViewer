package com.github.yuto5176.gummyviewer.data.repository

import com.github.yuto5176.gummyviewer.domain.repository.GummyInfoRepository
import javax.inject.Inject

class GummyInfoRepositoryImpl @Inject constructor(): GummyInfoRepository {
    override fun fetchData(): String {
        return "any info"
    }
}