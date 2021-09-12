package com.gulsah.todolist.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gulsah.todolist.R
import com.gulsah.todolist.adapter.ToDoAdapter
import com.gulsah.todolist.databinding.FragmentHomepageBinding
import com.gulsah.todolist.viewmodel.HomepageViewModel
import com.gulsah.todolist.viewmodelfactory.HomepageViewModelFactory

class HomepageFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomepageViewModel
    private lateinit var adapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)
        binding.fragment = this

        viewModel.todoList.observe(viewLifecycleOwner, {
            //adapter
            adapter = ToDoAdapter(it)
            binding.adapter = adapter
        })
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomepageViewModel by viewModels() {
            HomepageViewModelFactory(requireActivity().application)
        }
        setHasOptionsMenu(true)
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("Not yet implemented")
    }

}