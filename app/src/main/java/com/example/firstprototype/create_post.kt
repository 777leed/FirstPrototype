package com.example.firstprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstprototype.daos.PostDao
import com.example.firstprototype.models.Post
import kotlinx.android.synthetic.main.activity_create_post.*

class create_post : AppCompatActivity() {
    private lateinit var postDao:PostDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
        postDao=PostDao()
        postButton.setOnClickListener{
            val input=postInput.text.toString().trim()
            if(input.isNotEmpty()){
                postDao.addPost(input)
                finish()
            }
        }
    }
}