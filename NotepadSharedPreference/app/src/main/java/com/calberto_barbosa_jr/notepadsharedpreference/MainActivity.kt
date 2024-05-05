package com.calberto_barbosa_jr.notepadsharedpreference

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.calberto_barbosa_jr.notepadsharedpreference.databinding.ActivityMainBinding
import android.widget.Toast

// Frameworks and Controllers Layer
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteRepository: NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = applicationContext.getSharedPreferences("note.preference", 0)
        noteRepository = NoteRepositoryImpl(preferences)

        binding.fab.setOnClickListener {
            val retrievedNote = binding.editContainer.editNote.text.toString()

            if (retrievedNote.isBlank()) {
                Toast.makeText(this, "Enter something...", Toast.LENGTH_SHORT).show()
            } else {
                noteRepository.saveNote(Note(retrievedNote))
                Toast.makeText(this, "Note saved successfully!", Toast.LENGTH_SHORT).show()
            }
        }

        noteRepository.retrieveNote()?.let { note ->
            binding.editContainer.editNote.setText(note.text)
        }
    }
}