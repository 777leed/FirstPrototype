package com.example.firstprototype


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.example.firstprototype.R

class choose_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_choose1)
        val relativeLayout = findViewById<RelativeLayout>(R.id.lib)
        val relativeLayout1 = findViewById<RelativeLayout>(R.id.vd)
        relativeLayout.setOnClickListener{
            startActivity(Intent ( this@choose_1, pyslide::class.java))
        }
        relativeLayout1.setOnClickListener{
            startActivity(Intent ( this@choose_1, pyslide::class.java))
        }
    }
}
