package com.calberto_barbosa_jr.flow_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.calberto_barbosa_jr.flow_example.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun startFlow(view: View) {
        val messageTextView = binding.textView
        lifecycleScope.launch {
            startFlowCounter().collect { count ->
                messageTextView.text = "Contador: $count"
            }
        }
    }

    private fun startFlowCounter(): Flow<Int> = flow {
        for (i in 0..55) {
            delay(1000) // Delay within the coroutine
            emit(i)    // Emit the value to the Flow
        }
    }

    fun buttonName(view: View) {
        val editTextName = binding.editTextTextName
        val textViewName = binding.textViewName
        textViewName.text = editTextName.text.toString()
    }
}