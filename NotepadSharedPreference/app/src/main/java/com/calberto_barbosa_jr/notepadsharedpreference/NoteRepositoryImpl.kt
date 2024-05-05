package com.calberto_barbosa_jr.notepadsharedpreference

import android.content.SharedPreferences

class NoteRepositoryImpl(private val preferences: SharedPreferences) : NoteRepository {

    private val KEY = "name"

    override fun saveNote(note: Note) {
        preferences.edit().putString(KEY, note.text).apply()
    }

    override fun retrieveNote(): Note? {
        val text = preferences.getString(KEY, null)
        return text?.let { Note(it) }
    }
}