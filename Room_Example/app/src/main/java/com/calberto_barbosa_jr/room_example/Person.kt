package com.calberto_barbosa_jr.room_example

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var name: String,
    var email: String
)