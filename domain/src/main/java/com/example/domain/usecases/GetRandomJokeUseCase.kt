package com.example.domain.usecases

import com.example.domain.repository.RemoteJokesRepository
import com.example.domain.model.Joke
import com.example.domain.model.Result
import java.lang.Exception


class GetRandomJokeUseCase (private val remoteJokesRepository: RemoteJokesRepository) {

    suspend fun getRandomJokes(num: Int): Result<List<Joke>> {
        return try {
            remoteJokesRepository.getRandomJokes(num)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}