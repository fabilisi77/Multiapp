package com.example.multiapp.appTodo

data class Task (val name:String, val category: TaskCategory,var isSelected:Boolean = false)