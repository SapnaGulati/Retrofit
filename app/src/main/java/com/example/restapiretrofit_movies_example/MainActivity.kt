package com.example.restapiretrofit_movies_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pb = findViewById<MaterialButton>(R.id.post_button)
        val gb = findViewById<MaterialButton>(R.id.get_button)

        pb.setOnClickListener {
            val intent = Intent(this, PostData::class.java)
            startActivity(intent)
        }

        gb.setOnClickListener {
            val intent = Intent(this, GetDataActivity::class.java)
            startActivity(intent)
        }

    }
}