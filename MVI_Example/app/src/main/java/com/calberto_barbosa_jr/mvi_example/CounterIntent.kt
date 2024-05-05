package com.calberto_barbosa_jr.mvi_example

sealed class CounterIntent {
    object IncrementIntent : CounterIntent()
    object DecrementIntent : CounterIntent()
}