package com.vgubert.loockjson.data.room.repository

import androidx.lifecycle.LiveData
import com.vgubert.loockjson.data.room.dao.MoviesDao
import com.vgubert.loockjson.models.MovieItemModel

class MoviesRepositoryRealisation(private val moviesDao: MoviesDao): MoviesRepository {
    override val allMovies: LiveData<List<MovieItemModel>>
        get() = moviesDao.getAllMovies()

    override suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.insert(movieItemModel)
        onSuccess()
    }

    override suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.delete(movieItemModel)
        onSuccess()
    }
}