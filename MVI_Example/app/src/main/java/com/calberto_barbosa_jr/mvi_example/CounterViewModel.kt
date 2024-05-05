package com.calberto_barbosa_jr.mvi_example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> = _counter

    init {
        _counter.value = CounterRepository.getCount()
    }

    fun processIntent(intent: CounterIntent) {
        when (intent) {
            is CounterIntent.IncrementIntent -> incrementCounter()
            is CounterIntent.DecrementIntent -> decrementCounter()
        }
    }

    private fun incrementCounter() {
        CounterRepository.incrementCount()
        _counter.value = CounterRepository.getCount()
    }

    private fun decrementCounter() {
        CounterRepository.decrementCount()
        _counter.value = CounterRepository.getCount()
    }
}