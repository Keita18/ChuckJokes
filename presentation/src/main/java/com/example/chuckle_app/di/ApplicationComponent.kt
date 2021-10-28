package com.example.chuckle_app.di

import com.bumptech.glide.RequestManager
import com.example.chuckle_app.di.modules.ContextModule
import com.example.chuckle_app.di.modules.GlideModule
import com.example.chuckle_app.di.modules.RemoteJokesRepositoryModule
import com.example.chuckle_app.di.modules.UseCasesModule
import com.example.domain.usecases.GetRandomJokeUseCase
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [UseCasesModule::class,
    RemoteJokesRepositoryModule::class,
    ContextModule::class,
    GlideModule::class])
interface ApplicationComponent {

    fun getGetRandomJokeUseCase(): GetRandomJokeUseCase

    fun getGlide(): RequestManager
}