package com.gulsah.todolist.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gulsah.todolist.viewmodel.AddNewItemViewModel

class AddNewItemViewModelFactory (private val application: Application) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddNewItemViewModel(application) as T
    }
}
