package com.example.primeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val saludapp = findViewById<AppCompatButton>(R.id.btnSaludapp)
        saludapp.setOnClickListener {
            navigateToSaludapp()

        }
    }

    private fun navigateToSaludapp(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

    }
}