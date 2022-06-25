package com.vgubert.loockjson.screens.main

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vgubert.loockjson.MAIN
import com.vgubert.loockjson.REALISATION
import com.vgubert.loockjson.data.retrofit.RetrofitRepository
import com.vgubert.loockjson.data.room.MoviesRoomDatabase
import com.vgubert.loockjson.data.room.repository.MoviesRepositoryRealisation
import com.vgubert.loockjson.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val repository = RetrofitRepository()
    lateinit var realisation: MoviesRepositoryRealisation
    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()
    val context = application


    fun getMoviesRetrofit() {

        viewModelScope.launch {
            try {
                myMovies.value = repository.getMovies()
            } catch (e:Exception) {
                Toast.makeText(MAIN,e.message, Toast.LENGTH_SHORT).show()
            }

        }
    }
    fun initDatabase(){
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMovieDao()
        REALISATION = MoviesRepositoryRealisation(daoMovie)
    }

}