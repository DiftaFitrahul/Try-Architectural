package com.example.myapplication

import android.app.Application
import com.example.myapplication.animal.model.repository.AppContainer
import com.example.myapplication.animal.model.repository.DefaultAppContainer

class AnimalApplication : Application(){
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}