package com.example.firstprototype.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import com.example.firstprototype.R
import com.ramotion.fluidslider.FluidSlider

class Fm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fm)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setUpSlider()

    }
    private fun setUpSlider(){
        val slider = findViewById<FluidSlider>(R.id.fluid_slider)
        val text = findViewById<TextView>(R.id.lvl)
        val button = findViewById<Button>(R.id.btn_lvl)
        var lvl:Int = 0
        slider.positionListener = {
            text.text = (
                if (slider.position >= 0 && slider.position <0.2) {"Noob"}
                else if (slider.position > 0.2 && slider.position <0.4) {"Beginner"}
                else   if (slider.position > 0.4 && slider.position <0.8) {"Intermediate"}
                else "Advanced")
            button.isVisible=true
            }
    }

}