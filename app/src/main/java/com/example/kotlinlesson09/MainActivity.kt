package com.example.kotlinlesson09

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("user", Context.MODE_PRIVATE)
        val login = findViewById<TextInputLayout>(R.id.textInputLayout)
        val password = findViewById<TextInputLayout>(R.id.password_layout)
        val loginText = findViewById<TextInputEditText>(R.id.login_text)
        val passwordText = findViewById<TextInputEditText>(R.id.password_text)
        var loginPref = ""
        var passwordPref = ""


        fun validate() {

            login.error = if (!loginText.text.toString().equals("admin")) {
                "invalid login"
            } else {
                loginPref = loginText.text.toString()
                null
            }

            password.error = if (!passwordText.text.toString().equals("123456")) {
                "invalid password"
            } else {
                passwordPref = passwordText.text.toString()
                null
            }

            pref.edit().putString("login", loginPref).apply()
            pref.edit().putString("password", passwordPref).apply()

            if (loginText.text.toString().equals("admin") &&
                passwordText.text.toString().equals("123456")
            ) {
                startActivity(Intent(this, ResultActivity::class.java))
            }

        }

        passwordText.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    validate()

                    true
                }
                else -> false
            }
        }


    }
}
