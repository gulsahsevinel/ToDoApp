package com.gulsah.todolist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gulsah.todolist.R
import com.gulsah.todolist.databinding.FragmentAddNewListItemBinding
import com.gulsah.todolist.entity.ToDoItem
import com.gulsah.todolist.viewmodel.AddNewItemViewModel
import com.gulsah.todolist.viewmodel.HomepageViewModel
import com.gulsah.todolist.viewmodelfactory.AddNewItemViewModelFactory
import com.gulsah.todolist.viewmodelfactory.HomepageViewModelFactory

class AddNewListItemFragment : Fragment() {
    private lateinit var binding: FragmentAddNewListItemBinding
    private lateinit var viewModel: AddNewItemViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_new_list_item, container, false)

        binding.buttonAddNewItem.setOnClickListener {
            val item = binding.editTextItem.text.toString()
            val newItem = ToDoItem(0, item)
            viewModel.addNewToDo(newItem)

            Toast.makeText(requireContext(), "new item added", Toast.LENGTH_LONG).show()
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tempViewModel: AddNewItemViewModel by viewModels() {
            AddNewItemViewModelFactory(requireActivity().application)
        }
        setHasOptionsMenu(true)
        viewModel = tempViewModel
    }
}