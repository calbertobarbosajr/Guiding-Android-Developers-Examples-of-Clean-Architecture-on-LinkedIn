package com.calberto_barbosa_jr.dagger_example

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApp).appComponent.inject(this)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = context.getString(R.string.app_name)
    }
}
