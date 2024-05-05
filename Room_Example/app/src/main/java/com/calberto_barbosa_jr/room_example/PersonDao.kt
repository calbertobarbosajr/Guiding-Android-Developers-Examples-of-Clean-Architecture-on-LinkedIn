package com.calberto_barbosa_jr.room_example

import androidx.room.*

@Dao
interface PersonDao {
    @Insert
    suspend fun insert(person: Person)

    @Update
    suspend fun update(person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Query("SELECT * FROM people")
    suspend fun getAllPeople(): List<Person>
}