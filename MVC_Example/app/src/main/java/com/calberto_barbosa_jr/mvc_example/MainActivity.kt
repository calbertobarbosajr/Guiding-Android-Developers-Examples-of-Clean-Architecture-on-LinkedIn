package com.calberto_barbosa_jr.mvc_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.calberto_barbosa_jr.mvc_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val model = CounterModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateCounter()

        binding.incrementButton.setOnClickListener {
            model.increment()
            updateCounter()
        }

        binding.decrementButton.setOnClickListener {
            model.decrement()
            updateCounter()
        }
    }

    private fun updateCounter() {
        binding.counterTextView.text = model.getCount().toString()
    }
}
