package com.gulsah.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.gulsah.todolist.entity.ToDoItem
import com.gulsah.todolist.repo.ToDoDaoRepository

class HomepageViewModel(application: Application) : AndroidViewModel(application) {

    var todoList = MutableLiveData<List<ToDoItem>>()
    val repo = ToDoDaoRepository(application)

    init {
        todosLoad()
        todoList = repo.returnToDos()
    }

    fun todosLoad(){
        repo.getAllToDos()
    }
}
