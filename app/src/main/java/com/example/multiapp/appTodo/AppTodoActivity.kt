package com.example.multiapp.appTodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primeraapp.R


class AppTodoActivity : AppCompatActivity() {

    private val categories = listOf(
        TaskCategory.Business,
        TaskCategory.Other,
        TaskCategory.Personal
    )

    private val tasks = mutableListOf (
        Task("Prubea Businnes",TaskCategory.Business),
        Task("Prubea Personal",TaskCategory.Personal),
        Task("Prubea Other",TaskCategory.Other)



    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTask:RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_todo)

        initComponents()
        initUI()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTask = findViewById(R.id.rvTask)
    }

    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks)


    }
}