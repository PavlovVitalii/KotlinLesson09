package com.example.kotlinlesson09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login = findViewById<TextInputLayout>(R.id.textInputLayout)
        val password = findViewById<TextInputLayout>(R.id.password_layout)
        val loginText = findViewById<TextInputEditText>(R.id.login_text)
        val passwordText = findViewById<TextInputEditText>(R.id.password_text)


        fun validate() {
            var loginPref: String? = null
            var passwordPref: String? = null

            login.error = if (!loginText.text.toString().equals("admin")) {
                "invalid login"
            } else {
                null
                //  loginPref = loginText.text.toString()
            }

            password.error = if (!passwordText.text.toString().equals("123456")) {
                "invalid password"
            } else {
                null
                //  passwordPref = passwordText.text.toString()
            }

//            if (loginPref != null && passwordPref != null) {
//                pref.edit().putString("login", loginPref).apply()
//                pref.edit().putString("password",passwordPref).apply()
//            }
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
