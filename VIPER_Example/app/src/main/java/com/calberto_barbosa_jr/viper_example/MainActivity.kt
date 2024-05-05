package com.calberto_barbosa_jr.viper_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.calberto_barbosa_jr.viper_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this, MainInteractorImpl())
        presenter.onViewCreated()
    }

    override fun showLoading() {
        // Mostrar indicador de carregamento
    }

    override fun hideLoading() {
        // Ocultar indicador de carregamento
    }

    override fun displayWeather(weather: WeatherEntity) {
        // Exibir informações meteorológicas na UI
        binding.textViewTemperature.text = "${weather.temperature}°C"
        binding.textViewCondition.text = weather.condition
    }
}