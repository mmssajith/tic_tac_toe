package com.example.farmer_chess

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class About : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)

        var back_about = findViewById<Button>(R.id.back_about)
        back_about.setOnClickListener{
            startActivity(Intent(this@About, MainActivity::class.java))
        }
    }
}