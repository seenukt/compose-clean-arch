package com.example.cleanarchitecturecompose.di

import com.example.cleanarchitecturecompose.corutiens.CoroutinesManager
import com.example.cleanarchitecturecompose.data.remote.ApiIInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    single<Retrofit> {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    single {
        OkHttpClient.Builder()
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single { get<Retrofit>().create(ApiIInterface::class.java) }

    single { CoroutinesManager() }
}