package com.calberto_barbosa_jr.mvi_example

object CounterRepository {
    private var count = 0

    fun getCount(): Int {
        return count
    }

    fun incrementCount() {
        count++
    }

    fun decrementCount() {
        count--
    }
}