package com.example.solarsystem.di

import com.example.solarsystem.domain.InteractorImpl
import com.example.solarsystem.domain.Interactor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {


    @Binds
    @Singleton
    fun provideInteractor(impl: InteractorImpl): Interactor
}