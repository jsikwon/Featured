package com.ebookfrenzy.assignment10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.assignment10.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null


    private lateinit var viewModel: MainViewModel

    private val myCoroutineScope = CoroutineScope(Dispatchers.Main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        layoutManager = LinearLayoutManager(this)
        binding.recylerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(viewModel.getTitles())
        binding.recylerView.adapter = adapter

        binding.addNameBtn.setOnClickListener {
            displayName()

        }
    }


    fun displayName() {

        myCoroutineScope.launch(Dispatchers.Main) {
            pause()
        }
    }

    suspend fun pause() {
        val randomNumber = ((1..10).random() * 1000)
        val title = binding.enterName.text.toString()
        delay((randomNumber).toLong())
        if (title.isNotBlank()) {
            viewModel.addTitle("The name is $title and the delay was $randomNumber milliseconds")
            adapter?.notifyDataSetChanged()
            binding.enterName.text.clear()
        }

    }
}