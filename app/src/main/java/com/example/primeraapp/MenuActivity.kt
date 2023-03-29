package com.example.primeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.primeraapp.appTodo.AppTodoActivity
import com.example.primeraapp.imcCalculator.ImcAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val saludapp = findViewById<Button>(R.id.btnSaludapp)
        val imcApp = findViewById<Button>(R.id.btnImcApp)
        val appTODO = findViewById<Button>(R.id.appTODO)


        saludapp.setOnClickListener {
            navigateToSaludapp()
        }
        imcApp.setOnClickListener {
            navigateToImcapp()
        }
        appTODO.setOnClickListener {
            navigateToTodoAPP()
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
    private fun navigateToTodoAPP(){
        val intent = Intent(this, AppTodoActivity::class.java)
        startActivity(intent)
    }


}