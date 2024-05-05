package com.calberto_barbosa_jr.mvp_example

interface CounterPresenter {
    fun onIncrementButtonClicked()
    fun onDecrementButtonClicked()
}

class CounterPresenterImpl(private val view: CounterView) : CounterPresenter {
    private val model: CounterModel = CounterModelImpl()

    override fun onIncrementButtonClicked() {
        model.incrementCount()
        view.updateCountDisplay(model.getCount())
    }

    override fun onDecrementButtonClicked() {
        model.decrementCount()
        view.updateCountDisplay(model.getCount())
    }
}
