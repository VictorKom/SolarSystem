package com.example.solarsystem.di

import com.example.solarsystem.ui.navigation.Navigator
import com.example.solarsystem.ui.navigation.NavigatorImpl
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
