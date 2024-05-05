package com.calberto_barbosa_jr.room_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.calberto_barbosa_jr.room_example.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var personDao: PersonDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personDao = AppDatabase.getDatabase(this).personDao()

        binding.buttonInsert.setOnClickListener {
            val name = binding.editTextTextPersonName.text.toString()
            val email = binding.editTextTextPersonEmail.text.toString()
            val person = Person(name = name, email = email)
            insertPerson(person)
        }

        binding.buttonUpdate.setOnClickListener {
            val name = binding.editTextTextPersonName.text.toString()
            val email = binding.editTextTextPersonEmail.text.toString()
            updatePerson(name, email)
        }

        binding.buttonDelete.setOnClickListener {
            deletePerson()
        }
    }

    private fun read() {
        // Exemplo de leitura de todas as pessoas
        lifecycleScope.launch {
            val people = personDao.getAllPeople()
            val message = StringBuilder()
            for (p in people) {
                message.append("ID: ${p.id} \n Name: ${p.name} \n Email: ${p.email}\n\n")
            }
            binding.showMessage.text = message.toString()
        }
    }

    private fun insertPerson(person: Person) {
        // Exemplo de inserção
        lifecycleScope.launch {
            personDao.insert(person)
            read()
        }
    }

    private fun updatePerson(name: String, email: String) {
        // Exemplo de atualização
        lifecycleScope.launch {
            val people = personDao.getAllPeople()
            if (people.isNotEmpty()) {
                val personToUpdate = people[0]
                personToUpdate.name = name
                personToUpdate.email = email
                personDao.update(personToUpdate)
                read()
            }
        }
    }

    private fun deletePerson() {
        // Exemplo de exclusão
        lifecycleScope.launch {
            val people = personDao.getAllPeople()
            if (people.isNotEmpty()) {
                val personToDelete = people[0]
                personDao.delete(personToDelete)
                read()
            }
        }
    }
}