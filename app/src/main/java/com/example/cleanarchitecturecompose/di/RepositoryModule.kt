package com.example.cleanarchitecturecompose.di

import com.example.cleanarchitecturecompose.data.repository.GetPostRepository
import com.example.cleanarchitecturecompose.domine.use_case.get_post.GetAllPosts
import org.koin.dsl.module

val repositoryModule = module {
    single{ GetPostRepository(get()) }
    single{ GetAllPosts(get()) }
}