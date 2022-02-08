package com.example.farmer_chess

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAppLocale("no")
        setContentView(R.layout.activity_main)

        val startgamebutton = findViewById<Button>(R.id.startgamebutton)
        val exit = findViewById<Button>(R.id.exit)
        val about = findViewById<Button>(R.id.about)
        val settings = findViewById<Button>(R.id.settings)

        startgamebutton.setOnClickListener {
//            val intent = Intent(this, GameActivity::class.java)
            // start your next activity
            startActivity(Intent(this, GameActivity::class.java))
        }
        exit.setOnClickListener{
            ActivityCompat.finishAffinity(this)
        }
        about.setOnClickListener {
//            val intent = Intent(this, About::class.java)
            // start your next activity
            startActivity(Intent(this, About::class.java))
        }
        settings.setOnClickListener {
//            val intent = Intent(this, Settings::class.java)
            // start your next activity
            // start your next activity
            startActivity(Intent(this, Settings::class.java))
        }

    }

    private fun setAppLocale(localeCode: String) {
        val resources: Resources = resources
        val dm: DisplayMetrics = resources.getDisplayMetrics()
        val config: Configuration = resources.getConfiguration()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(Locale(localeCode.toLowerCase()))
        } else {
            config.locale = Locale(localeCode.toLowerCase())
        }
        resources.updateConfiguration(config, dm)
    }
}