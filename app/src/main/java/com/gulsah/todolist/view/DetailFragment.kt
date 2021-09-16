package com.gulsah.todolist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.gulsah.todolist.R
import com.gulsah.todolist.databinding.FragmentDetailBinding
import com.gulsah.todolist.entity.ToDoItem
import com.gulsah.todolist.viewmodel.DetailViewModel
import com.gulsah.todolist.viewmodelfactory.DetailViewModelFactory

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val item = bundle.item
        binding.item = item

        binding.buttonUpdate.setOnClickListener {
            val itemToDo = binding.editTextItem.text.toString()
            val newItem = ToDoItem(item.todo_id, itemToDo)
            viewModel.updateToDo(newItem)
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels() {
            DetailViewModelFactory(requireActivity().application)
        }
        viewModel = tempViewModel
    }
}