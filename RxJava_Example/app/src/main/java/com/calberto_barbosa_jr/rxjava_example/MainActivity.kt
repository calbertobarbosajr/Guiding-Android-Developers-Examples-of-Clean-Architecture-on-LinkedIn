package com.calberto_barbosa_jr.rxjava_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.calberto_barbosa_jr.rxjava_example.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun startRxjava(view: View) {
        val messageTextView = binding.textView
        disposable = Observable.interval(1, TimeUnit.SECONDS)
            .take(56) // Emit 56 items (0 to 55)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { i ->
                messageTextView.text = "Counter: $i"
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose() // Dispose of the subscription to avoid memory leaks
    }

    fun buttonName(view: View) {
        val editTextName = binding.editTextTextName
        val textViewName = binding.textViewName
        textViewName.text = editTextName.text.toString()
    }
}
