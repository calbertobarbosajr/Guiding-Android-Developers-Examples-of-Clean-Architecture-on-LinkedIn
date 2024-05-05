package com.calberto_barbosa_jr.notepadsharedpreference

// Use Cases Layer
interface NoteRepository {
    fun saveNote(note: Note)
    fun retrieveNote(): Note?
}