package com.example.primeraapp.appTodo

sealed class TaskCategory {
    object Personal:TaskCategory()
    object Business:TaskCategory()
    object Other:TaskCategory()
}