package com.example.chuckle_app.di.modules

import com.example.domain.repository.RemoteJokesRepository
import com.example.domain.usecases.GetRandomJokeUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCasesModule {

    @Provides
    fun provideGetRandomJokeUseCase(remote: RemoteJokesRepository): GetRandomJokeUseCase {
        return GetRandomJokeUseCase(remote)
    }
}