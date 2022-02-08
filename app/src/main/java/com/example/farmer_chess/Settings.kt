package com.example.farmer_chess

import android.R.id
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class Settings : AppCompatActivity(){
//    private lateinit var ox : Button
//    private lateinit var ab : Button
//    private lateinit var ab : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        val ox = findViewById<Button>(R.id.ox)
        val ab = findViewById<Button>(R.id.ab)
        val back = findViewById<Button>(R.id.back_settings)
        val option = findViewById<TextView>(R.id.option)
        ab.setOnClickListener{
            option.text = "a/b"
        }
        ox.setOnClickListener{
            option.text = "o/x"
        }
        back.setOnClickListener(){
            startActivity(Intent(this@Settings, MainActivity::class.java))
        }

    }
}