package com.example.multiapp.imcCalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.primeraapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider
import java.text.DecimalFormat

class ImcAppActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true

    /** acá no ponemos lateinit porque ya le estamos pasando un parámetro*/
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 50
    private var currentAge: Int = 25
    private var currentHeight: Int = 120
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeigth: TextView
    private lateinit var rsHeigth: Slider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button

    companion object {
        const val IMC_KEY ="IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_app)

        initComponents()
        initListeners()
        initUI()

    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeigth = findViewById(R.id.tvHieght)
        rsHeigth = findViewById(R.id.rsHeigth)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeigth)
        btnPlusWeight = findViewById(R.id.btnPlusWeigth)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)

    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeigth.addOnChangeListener { _, value, _ ->
            /**este Listener es de movimiento*/
            val df = DecimalFormat("#.##")

            /**acá le estamos diciendo que queremos que nos muestre un formato con un valor entero y dos decimales*/
            currentHeight = df.format(value).toInt()
            tvHeigth.text = "$currentHeight cm"
        }
        btnSubtractWeight.setOnClickListener {
            setWeight()
            currentWeight -= 1
        }
        btnPlusWeight.setOnClickListener {
            setWeight()
            currentWeight += 1
        }
        btnSubtractAge.setOnClickListener {
            setAge()
            currentAge -= 1
        }
        btnPlusAge.setOnClickListener {
            setAge()
            currentAge += 1
        }
        btnCalculate.setOnClickListener {
           val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ImcResultActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)

    }


    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)

        return df.format(imc).toDouble()

    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

    }

    /** La funcion setGenderColor se va  a llamar cada vez que clickiemos en viewMale o view Female,
     * dandonos el color que deseemos o hayamos creado */

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))


    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)

    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()

    }
}