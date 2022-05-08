package com.github.yuto5176.gummyviewer.di

import com.github.yuto5176.gummyviewer.domain.repository.GummyInfoRepository
import com.github.yuto5176.gummyviewer.repository.GummyInfoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindGummyInfoRepository(gummyInfoRepositoryImpl: GummyInfoRepositoryImpl):GummyInfoRepository
}