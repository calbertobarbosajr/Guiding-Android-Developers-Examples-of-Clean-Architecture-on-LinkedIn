package com.calberto_barbosa_jr.dagger_example

import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}
