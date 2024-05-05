package com.calberto_barbosa_jr.coroutine_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import com.calberto_barbosa_jr.coroutine_example.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun startCoroutine(view: View) {
        val messageTextView = binding.textView
        val myCoroutine = MyCoroutine(messageTextView)
        myCoroutine.start()
    }

    internal class MyCoroutine(private val messageTextView: TextView) {
        private val handler = Handler(Looper.getMainLooper())

        fun start() {
            CoroutineScope(Dispatchers.Default).launch {
                for (i in 0..55) {
                    handler.post {
                        messageTextView.text = "Contador: $i"
                    }

                    delay(1000)
                }
            }
        }
    }

    fun buttonName(view: View) {
        val editTextName = binding.editTextTextName
        val textViewName = binding.textViewName
        textViewName.text = editTextName.text.toString()
    }
}