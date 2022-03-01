package com.example.firstprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class nav_header : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_header)
        val prof = findViewById<ImageView>(R.id.userIcon)
        prof.setOnClickListener{
            startActivity(Intent ( this@nav_header,profil::class.java))
        }
    }
}