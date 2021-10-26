package com.example.data.repository

import com.example.data.network.JokesApiService
import com.example.domain.model.Joke
import com.example.domain.model.Result
import com.example.domain.repository.RemoteJokesRepository
import java.lang.Exception


class RemoteJokesRepositoryImpl(private val api: JokesApiService): RemoteJokesRepository {

    override suspend fun getRandomJokes(num: Int): Result<List<Joke>> {

        return try {
            val json =  api.getRandomJokes(num)
            val jsonJokes = json.asJsonObject.get("value")
            val list = jsonJokes.asJsonArray.map {
                Joke(it.asJsonObject.get("id").asInt, it.asJsonObject.get("joke").asString)
            }

            Result.Success(list)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}