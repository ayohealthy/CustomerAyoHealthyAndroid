package com.devatacreative.ayohealthy.di

import android.content.Context
import com.devatacreative.ayohealthy.data.RemoteDataSource
import com.devatacreative.ayohealthy.data.auth.AuthRepository
import com.devatacreative.ayohealthy.utils.NetworkingService

object Injection {
    fun provideAuthRepository(context: Context): AuthRepository{
        val remoteDataSource = RemoteDataSource.getInstance(NetworkingService(context))
        return AuthRepository.getInstance(remoteDataSource)
    }
}