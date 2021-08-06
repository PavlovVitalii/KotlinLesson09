package com.example.kotlinlesson09

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)

        Handler(Looper.getMainLooper()).postDelayed({

            val prefMup = sharedPreferences.all

            if (prefMup.size >= 2) {
                startActivity(Intent(this, ResultActivity::class.java))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }, 2000)

    }
}
