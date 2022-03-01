package com.example.firstprototype

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.firstprototype.User.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.example.firstprototype.databinding.ActivityProfilBinding



class profil : AppCompatActivity() {
//    ViewBinding
    private lateinit var binding: ActivityProfilBinding
    //ActionBar
    private lateinit var actionBar: ActionBar

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val btn_back = findViewById<ImageView>(R.id.back_arrow)
//        btn_back.setOnClickListener{
//            startActivity(Intent ( this@profil,home::class.java))
//        }
        //Configure ActionBar
        actionBar = supportActionBar!!
        actionBar.title = "Profile"

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click, logout
        val logout = findViewById<TextView>(R.id.logout)
        binding.logout.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }
    }
    private fun checkUser() {
        //check user is logged in or not
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            //user not null, user is logged in, get user info
            val email = firebaseUser.email
            //set to text view
            binding.email.text = email
        }
        else{
            //user is null, user is not loggedin, goto login activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}