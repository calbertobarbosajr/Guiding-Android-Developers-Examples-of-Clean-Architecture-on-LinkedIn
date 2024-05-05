package com.calberto_barbosa_jr.mvp_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.calberto_barbosa_jr.mvp_example.databinding.ActivityMainBinding

interface CounterView {
    fun updateCountDisplay(count: Int)
}

class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var presenter: CounterPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = CounterPresenterImpl(this)

        // Increment Button Click Listener
        binding.incrementButton.setOnClickListener {
            presenter.onIncrementButtonClicked()
        }

        // Decrement Button Click Listener
        binding.decrementButton.setOnClickListener {
            presenter.onDecrementButtonClicked()
        }
    }

    override fun updateCountDisplay(count: Int) {
        binding.countTextView.text = count.toString()
    }
}
