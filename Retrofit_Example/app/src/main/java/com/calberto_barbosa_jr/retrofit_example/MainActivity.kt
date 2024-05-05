package com.calberto_barbosa_jr.retrofit_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.calberto_barbosa_jr.retrofit_example.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var btnGetData: Button
    private lateinit var txtResult: TextView

    private lateinit var binding: ActivityMainBinding

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/") // Substitua pela sua URL da API
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: ApiService = retrofit.create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnGetData = binding.btnGetData //findViewById(R.id.btnGetData)
        txtResult = binding.txtResult  //findViewById(R.id.txtResult)

        btnGetData.setOnClickListener {
            fetchDataFromApi()
        }
    }

    private fun fetchDataFromApi() {
        val call: Call<User> = apiService.getUser()

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user: User? = response.body()
                    user?.let {
                        // Atualizar a TextView com os dados do usuário
                        val resultText = "ID: ${it.id}\nName: ${it.name}\nEmail: ${it.email}"
                        txtResult.text = resultText
                    }
                } else {
                    txtResult.text = "Erro na resposta da API"
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                txtResult.text = "Falha na solicitação: ${t.message}"
            }
        })
    }
}