package com.gulsah.todolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.todolist.databinding.RowTodoItemBinding
import com.gulsah.todolist.entity.ToDoItem

class ToDoAdapter(var todoList: List<ToDoItem>) :
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
        holder.rowTodoItemBinding.item = item

        holder.rowTodoItemBinding.todoItemTextView.text = item.todo_item

    }

    override fun getItemCount(): Int {
        return todoList.size
    }


}