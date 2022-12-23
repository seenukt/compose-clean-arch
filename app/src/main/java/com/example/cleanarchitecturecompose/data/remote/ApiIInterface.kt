package com.example.cleanarchitecturecompose.data.remote

import com.example.cleanarchitecturecompose.data.remote.dto.PostDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiIInterface {

    @GET("/posts")
    suspend fun getPosts():Response<List<PostDto>>


    @GET("/posts/{post}")
    suspend fun getPost(@Path("post") id:Int ):Response<PostDto>
}