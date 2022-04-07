package com.example.firstprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.firstprototype.choose.Categories
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class home : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val relativeLayout1 = findViewById<RelativeLayout>(R.id.lessons)
        val relativeLayout2 = findViewById<RelativeLayout>(R.id.codewar)
        relativeLayout1.setOnClickListener{
            startActivity(Intent ( this@home, Categories::class.java))
        }
        relativeLayout2.setOnClickListener{
            startActivity(Intent ( this@home, Feed::class.java))
        }
      val prof = findViewById<ImageView>(R.id.profilepic)
    prof.setOnClickListener{
    startActivity(Intent ( this@home,profil::class.java))
}
      val usernameDisplay = findViewById<TextView>(R.id.homeUser)
        val user = Firebase.auth.currentUser
        if (user != null) {
            usernameDisplay.text= user.displayName
        }
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.navView)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
//            Toast.makeText(applicationContext,
//                "Clicked Item 2", Toast.LENGTH_SHORT).show()
            when(it.itemId){
                R.id.item1 -> Toast.makeText(applicationContext,
                    "Clicked Item 1", Toast.LENGTH_SHORT).show()
                R.id.item2 ->
                    startActivity(Intent(this,Feed::class.java))

                R.id.item3 -> Toast.makeText(applicationContext,
                    "Clicked Item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}