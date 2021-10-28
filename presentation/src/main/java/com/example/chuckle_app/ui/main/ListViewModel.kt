package com.example.chuckle_app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Joke
import com.example.domain.model.Result
import com.example.domain.usecases.GetRandomJokeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListViewModel(private val getRandomJokeUseCase: GetRandomJokeUseCase): ViewModel() {

    private val mutableListJokes: MutableLiveData<List<Joke>> by lazy {
        MutableLiveData<List<Joke>>()
    }
    val listJokes: LiveData<List<Joke>> = mutableListJokes

    private val mutableToastMessage: MutableLiveData<String> = MutableLiveData()
    val toastMessage: LiveData<String> = mutableToastMessage

    init {
        mutableListJokes.value = listOf()
    }

    fun getJokes(num: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getRandomJokeUseCase.getRandomJokes(num)
            when(result) {
                is Result.Success -> mutableListJokes.postValue(result.data)
                is Result.Error -> showToast(result.error.message)
            }
        }
    }

    private fun showToast(msg: String?) {
        mutableToastMessage.postValue(msg)
    }

}