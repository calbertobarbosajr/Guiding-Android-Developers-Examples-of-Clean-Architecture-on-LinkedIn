package com.calberto_barbosa_jr.viper_example

interface MainContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun displayWeather(weather: WeatherEntity)
    }

    interface Presenter {
        fun onViewCreated()
    }

    interface Interactor {
        interface OnWeatherFetchedListener {
            fun onWeatherFetched(temperature: Double, condition: String)
        }

        fun fetchWeather(listener: OnWeatherFetchedListener)
    }
}