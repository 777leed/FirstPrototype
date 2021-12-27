package com.example.firstprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val imageView = findViewById<ImageView>(R.id.back_arrow)
        imageView.setOnClickListener{
            startActivity(Intent ( this@signup,MainActivity::class.java))

        }
    }
}