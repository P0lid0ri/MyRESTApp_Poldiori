package com.example.myrestapp_poldiori

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.security.MessageDigest

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val email = findViewById<TextView>(R.id.input_email)
        val password = findViewById<TextView>(R.id.input_password)
        val menu = findViewById<ImageButton>(R.id.button_image)

        menu.setOnClickListener {
            val email_input = email.text.toString()
            val password_input = password.text.toString()
            val pass = md5(password_input)
            input_check(email_input, pass)
        }
    }

    private fun input_check(email_input: String, pass: String) {
        val email = credenziali["email"]
        val password = credenziali["password"]

        if (email == email_input && password == pass) {
            start_activity(MenuActivity::class.java)
            Toast.makeText(this, "Login Avvenuto!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Errore Credenziali!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun start_activity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }

    private val credenziali = mapOf(
        "email" to "amendolaciuchetti@gmail.com",
        "password" to "7f4a82dab23d683b996d795860d61083" // password in  MD5 di "amendolaciuchetti"
    )

    private fun md5(input: String): String {
        val digest = MessageDigest.getInstance("MD5")
        val hashBytes = digest.digest(input.toByteArray())
        return hashBytes.joinToString("") { "%02x".format(it) }
    }
}
