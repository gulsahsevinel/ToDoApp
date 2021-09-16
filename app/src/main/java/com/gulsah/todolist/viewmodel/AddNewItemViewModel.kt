package com.gulsah.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gulsah.todolist.entity.ToDoItem
import com.gulsah.todolist.repo.ToDoDaoRepository

class AddNewItemViewModel(application: Application) : AndroidViewModel(application) {
    val repo = ToDoDaoRepository(application)

    fun addNewToDo(item: ToDoItem) {
        repo.addNewToDo(item)
    }
}