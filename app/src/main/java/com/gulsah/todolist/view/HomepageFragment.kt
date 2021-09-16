package com.gulsah.todolist.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
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
            adapter = ToDoAdapter(it, requireContext())

            val itemTouchHelperCallback = object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.bindingAdapterPosition
                    when (direction) {
                        ItemTouchHelper.LEFT -> {
                            viewModel.deleteItem(it[position])
                            adapter.notifyDataSetChanged()
                            //snackbar undo
                        }
                        ItemTouchHelper.RIGHT -> {
                            val transaction =
                                HomepageFragmentDirections.transaction(it[position])
                            findNavController().navigate(transaction)
                        }
                    }
                }

            }
            ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(binding.rv)
            binding.rv.adapter = adapter
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.addNewListItemFragment)
        }


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


    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.todosLoad()
    }

}