package com.vgubert.loockjson.data.retrofit.api

import com.vgubert.loockjson.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/popular?api_key=5f0a8b081ba30fc2343d1bfbe08a16b4&language=en-US&page=1")
    suspend fun  getPopularMovie(): Response<MoviesModel>
}