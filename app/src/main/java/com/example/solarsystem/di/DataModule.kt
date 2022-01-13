package com.example.solarsystem.di

import com.example.solarsystem.data.Repository
import com.example.solarsystem.data.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {


    @Binds
    @Singleton
    fun provideRepository(impl: RepositoryImpl): Repository
}
