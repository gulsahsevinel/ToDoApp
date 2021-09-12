package com.gulsah.todolist.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gulsah.todolist.entity.ToDoItem
import com.gulsah.todolist.room.ToDoDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ToDoDaoRepository(var application: Application) {
    private val db: ToDoDB
    private val todoList: MutableLiveData<List<ToDoItem>>

    init {
        db = ToDoDB.dbAccess(application)!!
        todoList = MutableLiveData()
    }

    fun returnToDos() : MutableLiveData<List<ToDoItem>>{
        return todoList
    }

    fun getAllToDos() {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            todoList.value = db.ToDoItemDao().allToDos()
        }
    }
}