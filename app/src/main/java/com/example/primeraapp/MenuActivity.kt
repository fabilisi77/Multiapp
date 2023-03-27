package com.example.primeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.example.primeraapp.imcCalculator.ImcAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val saludapp = findViewById<Button>(R.id.btnSaludapp)
        val imcApp = findViewById<Button>(R.id.btnImcApp)

        saludapp.setOnClickListener {
            navigateToSaludapp()
        }
        imcApp.setOnClickListener {
            navigateToImcapp()
        }
    }

    private fun navigateToSaludapp(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

    }

    private fun navigateToImcapp(){
        val intent = Intent (this, ImcAppActivity::class.java)
        startActivity(intent)

    }
}