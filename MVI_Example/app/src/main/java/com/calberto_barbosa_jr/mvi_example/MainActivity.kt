package com.calberto_barbosa_jr.mvi_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.calberto_barbosa_jr.mvi_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        observeViewModel()

        binding.incrementButton.setOnClickListener {
            viewModel.processIntent(CounterIntent.IncrementIntent)
        }

        binding.decrementButton.setOnClickListener {
            viewModel.processIntent(CounterIntent.DecrementIntent)
        }
    }

    private fun observeViewModel() {
        viewModel.counter.observe(this, Observer { count ->
            binding.countTextView.text = count.toString()
        })
    }
}