package com.example.chuckle_app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.GetRandomJokeUseCase


class ListViewModelFactory(private val getRandomJokeUseCase: GetRandomJokeUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(getRandomJokeUseCase::class.java).newInstance(getRandomJokeUseCase)
    }
}