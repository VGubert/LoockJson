package com.vgubert.loockjson.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vgubert.loockjson.REALISATION
import com.vgubert.loockjson.data.room.repository.MoviesRepositoryRealisation
import com.vgubert.loockjson.models.MovieItemModel

class FavoriteFragmentViewModel: ViewModel() {

    fun getAllMovies(): LiveData<List<MovieItemModel>> {
        return REALISATION.allMovies
    }
}