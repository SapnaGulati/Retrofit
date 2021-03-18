package com.example.restapiretrofit_movies_example.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Post {
    @SerializedName("title")
    @Expose
    private lateinit var title: String
    @SerializedName("body")
    @Expose
    private lateinit var body: String
    @SerializedName("userId")
    @Expose
    private lateinit var userId: String
    @SerializedName("id")
    @Expose
    private lateinit var id: String

    fun getTitle(): String {
        return title
    }

    fun getBody(): String {
        return body
    }

    fun getUserId(): String {
        return userId
    }

    fun getId(): String {
        return id
    }

    fun setTitle() {
        this.title = title
    }

    fun setBody() {
        this.body = body
    }

    fun setUserId() {
        this.userId = userId
    }

    fun setId() {
        this.id = id
    }

    override fun toString(): String {
        return "Post{" + "title='" + title + '\''  +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}'
    }

}