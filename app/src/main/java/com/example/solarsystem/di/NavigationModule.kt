package com.example.solarsystem.di

import com.example.solarsystem.ui.navigate.Navigator
import com.example.solarsystem.ui.navigate.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    @Singleton
    fun provideNavigator(impl: NavigatorImpl): Navigator
}
