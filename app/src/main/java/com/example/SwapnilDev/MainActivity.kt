package com.example.SwapnilDev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.SwapnilDev.adapter.MyAdapter
import com.example.SwapnilDev.data.Person
import com.example.SwapnilDev.databinding.ActivityMainBinding
import com.example.SwapnilDev.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding:ActivityMainBinding

    private val mainViewModel : MainViewModel by viewModels()
    private val myAdapter : MyAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = Person("Ana", "Brown", 38)
        mainViewModel.insertData(person)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter

        mainViewModel.readData.observe(this , {
            myAdapter.setData(it)}
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val search = menu?.findItem(R.id.menu)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)

        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if(newText != null){
            searchDatabase(newText)
        }
        return true
    }
    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"

        mainViewModel.searchDatabase(searchQuery).observe(this, { list ->
            list.let {
                myAdapter.setData(it)
            }
        })
    }
}