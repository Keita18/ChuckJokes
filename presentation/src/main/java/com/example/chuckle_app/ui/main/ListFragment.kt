package com.example.chuckle_app.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chuckle_app.R
import com.example.chuckle_app.listViewModelFactory
import com.example.chuckle_app.ui.main.adapters.JokesRecyclerAdapter
import com.example.domain.model.Joke
import kotlinx.android.synthetic.main.fragment_list.view.*


private lateinit var viewModel: ListViewModel
private lateinit var recyclerAdapter: JokesRecyclerAdapter
lateinit var recyclerView: RecyclerView
private lateinit var viewManager: LinearLayoutManager

class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(activity as AppCompatActivity, listViewModelFactory).get(
                ListViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        viewManager = LinearLayoutManager(view.context)
        recyclerAdapter = JokesRecyclerAdapter(view.context)
        recyclerView = view.recycler_view
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = recyclerAdapter
        }

        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }

        view.submit_button.setOnClickListener {
            viewModel.getJokes(view.num.text.toString().toInt())
            view.num.clearFocus()
            view.num.hideKeyboard()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //update list
        class MyObserver : Observer<List<Joke>> {
            override fun onChanged(items: List<Joke>) {
                recyclerAdapter.submitList(items)
            }
        }
        viewModel.listJokes.observe(viewLifecycleOwner, MyObserver())

        //show error
        viewModel.toastMessage .observe(viewLifecycleOwner, {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }
}