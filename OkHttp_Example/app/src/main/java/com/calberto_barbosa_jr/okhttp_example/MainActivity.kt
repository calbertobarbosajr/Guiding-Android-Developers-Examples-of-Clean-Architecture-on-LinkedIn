package com.calberto_barbosa_jr.okhttp_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.calberto_barbosa_jr.okhttp_example.databinding.ActivityMainBinding
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var btnGetData: Button
    private lateinit var txtResult: TextView

    private lateinit var binding: ActivityMainBinding

    private val okHttpClient: OkHttpClient = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnGetData = binding.btnGetData
        txtResult = binding.txtResult

        btnGetData.setOnClickListener {
            fetchDataFromApi()
        }
    }

    private fun fetchDataFromApi() {
        val request: Request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/users/1") // Substitua pela sua URL da API
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                response.body?.let {
                    try {
                        val json = JSONObject(it.string())
                        val id = json.getInt("id")
                        val name = json.getString("name")
                        val email = json.getString("email")

                        val resultText = "ID: $id\nName: $name\nEmail: $email"

                        runOnUiThread {
                            txtResult.text = resultText
                        }
                    } catch (e: Exception) {
                        runOnUiThread {
                            txtResult.text = "Erro ao processar a resposta da API"
                        }
                    }
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    txtResult.text = "Falha na solicitação: ${e.message}"
                }
            }
        })
    }
}