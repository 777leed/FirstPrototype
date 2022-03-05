package com.example.firstprototype.lessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.example.firstprototype.R
import com.example.firstprototype.cslide


class lessons_c3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons_c3)
        val relativeLayout = findViewById<RelativeLayout>(R.id.c)
        relativeLayout.setOnClickListener{
            startActivity(Intent ( this@lessons_c3, cslide::class.java))
        }
    }
}