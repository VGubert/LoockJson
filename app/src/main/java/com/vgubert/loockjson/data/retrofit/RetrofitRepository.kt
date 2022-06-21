package com.vgubert.loockjson.data.retrofit

import com.vgubert.loockjson.data.retrofit.api.RetrofitInstance
import com.vgubert.loockjson.models.MoviesModel
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMovies(): Response<MoviesModel> {
        return RetrofitInstance.api.getPopularMovie()
    }
}