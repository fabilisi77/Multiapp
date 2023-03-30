package com.example.multiapp.appTodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.primeraapp.R

class AppTodoActivity : AppCompatActivity() {
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_todo)

        initComponents()
        initUI()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
    }

    private fun initUI(){


    }
}