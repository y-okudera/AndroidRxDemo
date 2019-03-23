package com.yuoku.androidRxDemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yuoku.androidRxDemo.Models.HelloWorld

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = HelloWorld()
        model.sayHello()

        val words = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
        model.extractWordsFiveCharacters(words)
    }
}
