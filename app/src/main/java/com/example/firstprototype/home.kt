package com.example.firstprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val relativeLayout1 = findViewById<RelativeLayout>(R.id.lessons)
        relativeLayout1.setOnClickListener{
            startActivity(Intent ( this@home,Categories::class.java))
        }
    }
}