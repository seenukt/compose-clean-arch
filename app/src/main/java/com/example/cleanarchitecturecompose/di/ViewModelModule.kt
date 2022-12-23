package com.example.cleanarchitecturecompose.di


import com.example.cleanarchitecturecompose.presentation.DummyViewModel
import com.example.cleanarchitecturecompose.presentation.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
 viewModel { MainActivityViewModel() }
 viewModel { DummyViewModel(get(),get()) }
}