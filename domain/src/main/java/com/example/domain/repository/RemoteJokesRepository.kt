package com.example.domain.repository

import com.example.domain.model.Joke
import com.example.domain.model.Result


interface RemoteJokesRepository {
    suspend fun getRandomJokes(num: Int): Result<List<Joke>>
}