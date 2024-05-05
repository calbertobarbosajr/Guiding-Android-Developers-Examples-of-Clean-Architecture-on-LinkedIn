package com.calberto_barbosa_jr.viper_example

class MainPresenter(private val view: MainContract.View, private val interactor: MainContract.Interactor) :
    MainContract.Presenter, MainContract.Interactor.OnWeatherFetchedListener {

    override fun onViewCreated() {
        view.showLoading()
        interactor.fetchWeather(this)
    }

    override fun onWeatherFetched(temperature: Double, condition: String) {
        view.hideLoading()
        view.displayWeather(WeatherEntity(temperature, condition))
    }
}