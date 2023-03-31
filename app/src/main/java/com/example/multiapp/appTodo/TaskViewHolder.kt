package com.example.multiapp.appTodo

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.primeraapp.R

class TaskViewHolder (view:View):RecyclerView.ViewHolder(view) {
    private val cbTask : CheckBox = view.findViewById(R.id.cbTask)
    private val tvTask: TextView = view.findViewById(R.id.tvTask)

    fun render (task: Task){

    }
}