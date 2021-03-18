package com.example.restapiretrofit_movies_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.restapiretrofit_movies_example.data.model.Post
import com.example.restapiretrofit_movies_example.data.remote.APIService
import com.example.restapiretrofit_movies_example.data.remote.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostData : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var apiService: APIService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_data)

        val title = findViewById<EditText>(R.id.title)
        val data = findViewById<EditText>(R.id.data)
        val btn = findViewById<Button>(R.id.button)
        val request = ServiceBuilder.buildService(APIService::class.java)
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
        apiService.savePost(title, body, 1)?.enqueue(object: Callback<Post?> {
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                if (response.isSuccessful) {
                    showResponse(response.body().toString())
                    Log.i("TAG", "Post submitted successfully" + response.body().toString())
                }
            }
            override fun onFailure(call: Call<Post?>, t: Throwable) {
                Log.e("TAG", "Submitting post un-successful")
            }
        })
    }

    fun showResponse(string: String) {
        if (textView.visibility == View.GONE) {
            textView.visibility = View.VISIBLE
        }
        textView.text = string
    }
}