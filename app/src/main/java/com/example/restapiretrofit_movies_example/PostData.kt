package com.example.restapiretrofit_movies_example

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.restapiretrofit_movies_example.data.model.Post
import com.example.restapiretrofit_movies_example.data.remote.APIService
import com.example.restapiretrofit_movies_example.data.remote.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostData : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var apiService: APIService
    private lateinit var call: Call<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_data)

        val title = findViewById<EditText>(R.id.title)
        val data = findViewById<EditText>(R.id.data)
        val btn = findViewById<Button>(R.id.button)
        textView = findViewById(R.id.textView)
        apiService = ApiUtils.getAPIService()!!

        btn.setOnClickListener {
            val title = title.text.toString().trim()
            val body = data.text.toString().trim()
            if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                sendPost(title, body)
            }
        }
    }

    private fun sendPost(title: String, body: String) {
        val call = apiService.savePost(title = title, body = body, userId = 1)
        call?.enqueue(object : Callback<Post?> {
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                if (response.isSuccessful) {
                    showResponse(response.body().toString())
                    Log.i("TAG", "Post submitted successfully" + response.body().toString())
                }
            }

            override fun onFailure(call: Call<Post?>, t: Throwable) {
                if(call.isCanceled) {
                    Log.e("TAG", "Submitting post was aborted")
                }
                else {
                    Log.e("TAG", "Submitting post un-successful")
                }
            }
        })
    }

    fun cancelRequest() {
        call.cancel()
    }

    fun showResponse(string: String) {
        if (textView.visibility == View.GONE) {
            textView.visibility = View.VISIBLE
        }
        textView.text = string
    }
}