package com.example.restapiretrofit_movies_example.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private var retrofit: Retrofit? = null
    var baseURL = "https://api.themoviedb.org/3/"

    fun getClient(baseUrl: String): Retrofit?{
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit
    }

}