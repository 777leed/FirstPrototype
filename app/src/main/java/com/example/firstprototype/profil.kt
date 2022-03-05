package com.example.firstprototype

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.firstprototype.User.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.example.firstprototype.databinding.ActivityProfilBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class profil : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        val btn_back = findViewById<ImageView>(R.id.back_arrow)
        val logout = findViewById<TextView>(R.id.logout)
        btn_back.setOnClickListener {
            startActivity(Intent(this@profil, home::class.java))
        }
    logout.setOnClickListener{
        SignOut()
        }

    }
    private fun SignOut(){
        Firebase.auth.signOut()
        startActivity(Intent(this, MainActivity::class.java))
    }


}

