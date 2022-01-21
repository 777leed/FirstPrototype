package com.example.firstprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView

class lessons_c1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons_c1)
        val relativeLayout = findViewById<RelativeLayout>(R.id.python)
        relativeLayout.setOnClickListener{
            startActivity(Intent ( this@lessons_c1,pdfActivity::class.java))
        }
    }
}