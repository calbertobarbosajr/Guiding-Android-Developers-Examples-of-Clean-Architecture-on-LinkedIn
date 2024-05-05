package com.calberto_barbosa_jr.notepaddatastore

// Use Case Layer
interface NoteRepository {
    suspend fun saveNote(note: Note)
    suspend fun retrieveNote(): Note?
}