package com.calberto_barbosa_jr.notepaddatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.preferencesDataStore

class NoteRepositoryImpl(private val context: Context) : NoteRepository {

    private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore(name = "note")

    override suspend fun saveNote(note: Note) {
        context.dataStore.edit { preferences ->
            preferences[stringPreferencesKey(KEY)] = note.text
        }
    }

    override suspend fun retrieveNote(): Note? {
        val noteText = context.dataStore.data.map { preferences ->
            preferences[stringPreferencesKey(KEY)] ?: ""
        }.first()

        return if (noteText.isNotEmpty()) Note(noteText) else null
    }

    companion object {
        private const val KEY = "name"
    }
}