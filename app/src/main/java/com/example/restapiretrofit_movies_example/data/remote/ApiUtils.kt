package com.example.restapiretrofit_movies_example.data.remote

object ApiUtils {
    private const val baseURL = "http://jsonplaceholder.typicode.com/"

    fun getAPIService(): APIService? {
        return null
//        return RetrofitClient.getClient(baseURL).create<APIService>(APIService::class.java)
    }
}