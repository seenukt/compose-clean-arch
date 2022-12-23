package com.example.cleanarchitecturecompose.domine.repository

import com.example.cleanarchitecturecompose.common.network.NetWorkResults
import com.example.cleanarchitecturecompose.data.remote.dto.PostDto
import retrofit2.Response

interface PostRepository {

    suspend fun  getPosts():Response<List<PostDto>>

    suspend fun getPostById():Response<PostDto>
}