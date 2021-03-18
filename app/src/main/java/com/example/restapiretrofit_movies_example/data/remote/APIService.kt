package com.example.restapiretrofit_movies_example.data.remote

import com.example.restapiretrofit_movies_example.data.model.Post
import retrofit2.Call
import retrofit2.http.*


interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    open fun savePost(@Field("title") title: String?,
                      @Field("body") body: String?,
                      @Field("userId") userId: Long): Call<Post?>?

    @PUT("/posts/{id}")
    @FormUrlEncoded
    fun updatePost(@Path("id") id: Long,
                   @Field("title") title: String?,
                   @Field("body") body: String?,
                   @Field("userId") userId: Long): Call<Post?>?

    @DELETE("/posts/{id}")
    fun deletePost(@Path("id") id: Long): Call<Post?>?
}