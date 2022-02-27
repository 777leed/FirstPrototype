package com.example.firstprototype.lessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.example.firstprototype.R
import com.example.firstprototype.pdf.pdfActivity_1

class lessons_c1 : AppCompatActivity() {
    lateinit var src : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons_c1)
        val relativeLayout = findViewById<RelativeLayout>(R.id.python)
        val r2 = findViewById<RelativeLayout>(R.id.javaR)

        relativeLayout.setOnClickListener{
            startActivity(Intent ( this@lessons_c1, pdfActivity_1::class.java))
        }
        r2.setOnClickListener{
            startActivity(Intent ( this@lessons_c1, pdfActivity_1::class.java))
        }

    }

}