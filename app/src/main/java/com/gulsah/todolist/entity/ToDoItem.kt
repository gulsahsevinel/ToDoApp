package com.gulsah.todolist.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "todolist")
data class ToDoItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id")
    @NotNull
    var todo_id: Int,
    @ColumnInfo(name = "todo_item")
    @NotNull
    val todo_item: String
) : Serializable {
}