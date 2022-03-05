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
        supportActionBar?.hide()
        setContentView(R.layout.activity_profil)
        val btn_back = findViewById<ImageView>(R.id.back_arrow)
        val logout = findViewById<TextView>(R.id.logout)
        btn_back.setOnClickListener {
            startActivity(Intent(this@profil, home::class.java))
        }
    logout.setOnClickListener{
        SignOut()
        }
        getUserInfo()
    }
    private fun getUserInfo(){
        val user = Firebase.auth.currentUser
        user?.let {
            val e= findViewById<TextView>(R.id.tv_email)
            val n= findViewById<TextView>(R.id.tv_profile_fragment_username)
            val m= findViewById<ImageView>(R.id.tv_pic)
            val userdisplayname =findViewById<TextView>(R.id.userDisplay)
            val userdisplayhome =findViewById<TextView>(R.id.homeUser)

            // Name, email address, and profile photo Url
            val name = user.displayName

            val email = user.email
            val photoUrl = user.photoUrl
            e.text = email
            n.text=name
            userdisplayname.text=name
            val emailVerified = user.isEmailVerified
            val uid = user.uid
        }
    }

    private fun SignOut(){
        Firebase.auth.signOut()
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }


}

