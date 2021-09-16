package com.gulsah.todolist.adapter

import android.content.Context
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.todolist.databinding.RowTodoItemBinding
import com.gulsah.todolist.entity.ToDoItem

class ToDoAdapter(var todoList: List<ToDoItem>, var mContext: Context) :
    RecyclerView.Adapter<ToDoAdapter.CardViewHolder>() {


    inner class CardViewHolder(rowTodoItemBinding: RowTodoItemBinding) :
        RecyclerView.ViewHolder(rowTodoItemBinding.root) {
        var rowTodoItemBinding: RowTodoItemBinding

        init {
            this.rowTodoItemBinding = rowTodoItemBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = RowTodoItemBinding.inflate(layoutInflater, parent, false)
        return CardViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = todoList[position]

        holder.rowTodoItemBinding.todoItemTextView.text = item.todo_item

            if (holder.rowTodoItemBinding.checkBox.isChecked) {

                Toast.makeText(mContext, "Checked", Toast.LENGTH_LONG).show()
                holder.rowTodoItemBinding.todoItemTextView.apply {
                    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                }
            }
        holder.rowTodoItemBinding.item = item
    }


    override fun getItemCount(): Int {
        return todoList.size
    }


}

