package com.example.primeraapp.imcCalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.primeraapp.R
import com.example.primeraapp.imcCalculator.ImcAppActivity.Companion.IMC_KEY

class ImcResultActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnNewCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)


        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)

    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()

        when (result) {
            in 0.00..18.50 -> {
                tvResult
                tvDescription
            }
            in 18.51..24.99 -> {
                tvResult
                tvDescription
            }
            in 25.00..29.99 -> {
                tvResult
                tvDescription

            }
            in 30.00..99.00 -> {
                tvResult
                tvDescription
            }
            else-> {
                tvResult.text =getString(R.string.error)
                tvIMC.text =getString(R.string.error)
                tvDescription.text =getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnNewCalculate = findViewById(R.id.btnNewCalculate)
    }

}