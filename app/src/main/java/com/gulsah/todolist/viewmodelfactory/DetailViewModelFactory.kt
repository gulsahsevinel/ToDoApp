package com.gulsah.todolist.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gulsah.todolist.viewmodel.DetailViewModel

class DetailViewModelFactory (private val application: Application) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(application) as T
    }
}
