package com.example.firstprototype

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.*
import com.example.firstprototype.User.MainActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class signup : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_signup)
        auth = FirebaseAuth.getInstance()
        val btn_signup = findViewById<Button>(R.id.button_started)

        btn_signup.setOnClickListener {
            signUpUser()
        }

    }
    private fun updateProfile() {
        val user = auth.currentUser
        user?.let { user ->
            val username = findViewById<EditText>(R.id.username).toString()
            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(username)
                .build()

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    user.updateProfile(profileUpdates).await()
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@signup, "Successfully updated profile",
                            Toast.LENGTH_LONG).show()
                    }
                } catch(e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@signup, e.message, Toast.LENGTH_LONG).show()
                    }
                }

            }
        }
    }

    private fun signUpUser() {
        val db = Firebase.firestore
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<TextInputLayout>(R.id.password)
        val username = findViewById<EditText>(R.id.username)
        if (email.text.toString().isEmpty()) {
            email.error = "Please enter email"
            email.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            email.error = "Please enter valid email"
            email.requestFocus()
            return
        }

        if (password.editText?.text.toString().isEmpty()) {
            password.error = "Please enter password"
            password.requestFocus()
            return
        }

        if (username.text.toString().isEmpty()) {
            username.error = "Please enter username"
            username.requestFocus()
            return
        }


        auth.createUserWithEmailAndPassword(email.text.toString(), password.editText?.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val profileUpdates = userProfileChangeRequest {
                        displayName = username.text.toString()
                        photoUri = Uri.parse("https://starzplay-img-prod-ssl.akamaized.net/474w/universal/MRROBOTY2015S01E001/MRROBOTY2015S01E001-474x677-PST.jpg")
                    }

                    user!!.updateProfile(profileUpdates)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d(TAG, "User profile updated.")
                            }
                        }
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val u = hashMapOf(
                                    "username" to username.text.toString(),
                                    "level" to "1"


                                )
// Add a new document with a generated ID
                                db.collection("users")
                                    .add(u)
                                    .addOnSuccessListener { documentReference ->
                                        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                                    }
                                    .addOnFailureListener { e ->
                                        Log.w(TAG, "Error adding document", e)
                                    }
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }
                        }
                } else {
                    Toast.makeText(
                        baseContext, "Sign Up failed. Try again after some time.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }
}