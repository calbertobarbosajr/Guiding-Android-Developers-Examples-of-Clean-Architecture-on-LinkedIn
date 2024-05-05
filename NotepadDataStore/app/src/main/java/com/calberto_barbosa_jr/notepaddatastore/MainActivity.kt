package com.calberto_barbosa_jr.notepaddatastore

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.calberto_barbosa_jr.notepaddatastore.databinding.ActivityMainBinding
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Frameworks and Controllers Layer
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteRepository: NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteRepository = NoteRepositoryImpl(context = this)

        binding.fab.setOnClickListener {
            val retrievedNote = binding.editContainer.editNote.text.toString()

            if (retrievedNote.isBlank()) {
                Toast.makeText(this, "Enter something...", Toast.LENGTH_SHORT).show()
            } else {
                lifecycleScope.launch {
                    noteRepository.saveNote(Note(retrievedNote))
                    Toast.makeText(this@MainActivity, "Note saved successfully!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        lifecycleScope.launch {
            noteRepository.retrieveNote()?.let { note ->
                binding.editContainer.editNote.setText(note.text)
            }
        }
    }
}