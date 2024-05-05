package com.calberto_barbosa_jr.viper_example

class MainInteractorImpl : MainContract.Interactor {
    override fun fetchWeather(listener: MainContract.Interactor.OnWeatherFetchedListener) {
        // Simulação de chamada assíncrona a uma API de clima
        val temperature = 25.0
        val condition = "Sunny"

        // Simulação de resposta bem-sucedida
        listener.onWeatherFetched(temperature, condition)
    }
}