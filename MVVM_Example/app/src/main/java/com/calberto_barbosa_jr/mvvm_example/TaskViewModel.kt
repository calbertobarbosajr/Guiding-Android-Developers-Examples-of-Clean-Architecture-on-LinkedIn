package com.calberto_barbosa_jr.mvvm_example

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    val tasks = MutableLiveData<List<Task>>()

    init {
        tasks.value = emptyList()
    }

    fun addTask(task: Task) {
        val currentList = tasks.value.orEmpty().toMutableList()
        currentList.add(task)
        tasks.value = currentList
    }
}