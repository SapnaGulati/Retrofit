package com.example.restapiretrofit_movies_example.data.remote

object ApiUtils {
    private const val baseURL = "https://jsonplaceholder.typicode.com/"

    fun getAPIService(): APIService {
        return RetrofitClient.getClient(baseURL)!!.create<APIService>(APIService::class.java)
    }
}