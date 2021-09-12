package com.gulsah.todolist.room

import androidx.room.*
import com.gulsah.todolist.entity.ToDoItem

@Dao
interface ToDoItemDao {
    @Query("SELECT * FROM todolist")
    suspend fun allToDos(): List<ToDoItem>

    @Query("SELECT * FROM todolist WHERE todo_item like '%'||:query||'%'")
    suspend fun todoSearch(query: String): List<ToDoItem>

    @Insert
    suspend fun todoAdd(item : ToDoItem)

    @Update
    suspend fun todoUpdate(item : ToDoItem)

    @Delete
    suspend fun todoDelete(item : ToDoItem)
}