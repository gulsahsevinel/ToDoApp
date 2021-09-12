package com.gulsah.todolist.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gulsah.todolist.entity.ToDoItem

@Database(entities = [ToDoItem::class], version = 1)
abstract class ToDoDB : RoomDatabase() {
    abstract fun ToDoItemDao(): ToDoItemDao

    companion object {
        var INSTANCE: ToDoDB? = null

        fun dbAccess(context: Context): ToDoDB? {
            if (INSTANCE == null) {
                synchronized(ToDoDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoDB::class.java,
                        "todolist.sqlite"
                    ).createFromAsset("todolist.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}