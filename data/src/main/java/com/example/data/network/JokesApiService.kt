package com.example.data.network

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


const val BASE_URL = "https://api.icndb.com/"

interface JokesApiService {

    @GET("jokes/random/{num}")
    suspend fun getRandomJokes(@Path("num") num: Int): JsonElement

    companion object {
        private val gson = GsonBuilder()
                .create()

        private val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        fun get(): JokesApiService {
            return retrofit.create(JokesApiService::class.java)
        }

    }

}