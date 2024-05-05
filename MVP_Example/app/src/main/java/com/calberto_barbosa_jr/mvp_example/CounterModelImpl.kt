package com.calberto_barbosa_jr.mvp_example

interface CounterModel {
    fun incrementCount()
    fun decrementCount()
    fun getCount(): Int
}

class CounterModelImpl : CounterModel {
    private var count = 0

    override fun incrementCount() {
        count++
    }

    override fun decrementCount() {
        if (count > 0) {
            count--
        }
    }

    override fun getCount(): Int {
        return count
    }
}