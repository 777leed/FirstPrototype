package com.example.firstprototype.User

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.firstprototype.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class forgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_forget_password)
        val btn_reset = findViewById<Button>(R.id.btn_reset)
        btn_reset.setOnClickListener {
            resetPass()
        }
    }
    private fun resetPass(){
        val email= findViewById<EditText>(R.id.resetEmail)
        val emailAddress = email.text.toString()
        Firebase.auth.sendPasswordResetEmail(emailAddress)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Email sent.")
                    Toast.makeText(
                        baseContext, "Email Sent,Check your Inbox.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}