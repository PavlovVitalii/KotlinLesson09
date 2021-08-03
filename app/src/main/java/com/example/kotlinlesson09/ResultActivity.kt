package com.example.kotlinlesson09

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)

        textView.text = "Login: ${sharedPreferences.getString("login", 0.toString())}\n" +
                "Password: ${sharedPreferences.getString("password", 0.toString())}"


    }
}
