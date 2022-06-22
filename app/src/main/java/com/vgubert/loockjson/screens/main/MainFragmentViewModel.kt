package com.vgubert.loockjson.screens.main

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vgubert.loockjson.MAIN
import com.vgubert.loockjson.data.retrofit.RetrofitRepository
import com.vgubert.loockjson.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel: ViewModel() {
    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()

    fun getMovies() {

        viewModelScope.launch {
            try {
                myMovies.value = repository.getMovies()
            } catch (e:Exception) {
                Toast.makeText(MAIN,e.message, Toast.LENGTH_SHORT).show()
            }

        }
    }
}