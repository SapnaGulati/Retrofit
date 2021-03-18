package com.example.restapiretrofit_movies_example.data.remote

import com.example.restapiretrofit_movies_example.data.model.Post
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    open fun savePost(@Field("title") title: String?,
                  @Field("body") body: String?,
                  @Field("userId") userId: Long): Call<Post?>?
}