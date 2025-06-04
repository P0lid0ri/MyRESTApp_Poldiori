package com.example.myrestapp_poldiori

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val imageview= findViewById<ImageButton>(R.id.btn_netflix)
        imageview.setOnClickListener{
            start_activity(WebviewActivity::class.java)
        }
        val searchfilm= findViewById<ImageButton>(R.id.btn_search)
        searchfilm.setOnClickListener{
            start_activity(SearchActivity::class.java)
        }
        val crud = findViewById<ImageButton>(R.id.btn_crud)
        crud.setOnClickListener{
            start_activity(DashboardActivity::class.java)
        }
    }
    fun start_activity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}