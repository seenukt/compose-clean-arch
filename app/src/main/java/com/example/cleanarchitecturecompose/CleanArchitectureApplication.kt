package com.example.cleanarchitecturecompose

import android.app.Application
import com.example.cleanarchitecturecompose.di.networkModule
import com.example.cleanarchitecturecompose.di.repositoryModule
import com.example.cleanarchitecturecompose.di.viewModelModule
import org.koin.core.context.startKoin

class CleanArchitectureApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            applicationContext
            modules(listOf(viewModelModule, networkModule, repositoryModule))
        }
    }
}