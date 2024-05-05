package com.calberto_barbosa_jr.mvc_example

class CounterModel {
    private var count: Int = 0

    fun getCount(): Int {
        return count
    }

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }
}