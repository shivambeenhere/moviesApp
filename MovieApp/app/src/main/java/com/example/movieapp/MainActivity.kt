package com.example.movieapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainActivityVM
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoviePagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEt : EditText = findViewById(R.id.etSearch)
        val searchBtn : Button = findViewById(R.id.searchBtn)

        recyclerView = findViewById(R.id.rvMovieList)
        adapter = MoviePagingAdapter()
        viewModel = ViewModelProvider(this).get(MainActivityVM::class.java)

        searchBtn.setOnClickListener {
            viewModel.triggerSearch.postValue(searchEt.toString())
        }

        viewModel.movieList.observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })
    }
}