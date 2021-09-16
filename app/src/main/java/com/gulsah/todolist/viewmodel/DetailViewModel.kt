package com.gulsah.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gulsah.todolist.entity.ToDoItem
import com.gulsah.todolist.repo.ToDoDaoRepository

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    val repo = ToDoDaoRepository(application)

    fun updateToDo(item: ToDoItem) {
        repo.update(item)
    }

}