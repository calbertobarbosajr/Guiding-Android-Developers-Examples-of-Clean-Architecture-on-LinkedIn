package com.calberto_barbosa_jr.threads_example

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.calberto_barbosa_jr.threads_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun startThread(view: View) {
        val messageTextView = binding.textView
        val myThread = MyThread(messageTextView)
        myThread.start()
    }

    internal class MyThread(private val messageTextView: TextView) : Thread() {
        private val handler = Handler(Looper.getMainLooper())

        override fun run() {
            for (i in 0..55) {
                handler.post {
                    messageTextView.text = "Counter: $i"
                }

                try {
                    sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
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