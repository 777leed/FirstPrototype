package com.example.firstprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class levels : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_levels)
    }
}