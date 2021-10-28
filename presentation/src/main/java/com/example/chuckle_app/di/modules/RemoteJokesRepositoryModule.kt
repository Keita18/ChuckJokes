package com.example.chuckle_app.di.modules

import com.example.data.network.JokesApiService
import com.example.data.repository.RemoteJokesRepositoryImpl
import com.example.domain.repository.RemoteJokesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteJokesRepositoryModule {

    @Provides
    fun provideRemoteHabitRepository(api: JokesApiService): RemoteJokesRepository {
        return RemoteJokesRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideApiService(): JokesApiService {
        return JokesApiService.get()
    }
}