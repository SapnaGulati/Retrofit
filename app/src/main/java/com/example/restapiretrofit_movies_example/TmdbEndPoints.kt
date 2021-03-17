package com.example.restapiretrofit_movies_example

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbEndPoints {
    @GET("/3/movie/popular")
    fun getMovies(@Query("api_key") key: String): Call<PopularMovies>
}