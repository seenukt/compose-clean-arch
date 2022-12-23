package com.example.cleanarchitecturecompose.domine.use_case.get_post

import android.util.Log
import com.example.cleanarchitecturecompose.common.network.NetWorkResults
import com.example.cleanarchitecturecompose.common.network.safeApiCall
import com.example.cleanarchitecturecompose.data.remote.dto.PostDto
import com.example.cleanarchitecturecompose.data.repository.GetPostRepository

class GetAllPosts(private val repo:GetPostRepository) {


    suspend fun getAllPosts ():NetWorkResults<List<PostDto>>{
        return  safeApiCall(
        call =  { getAllPost() },"Failure Error"
     )

    }


    private suspend fun getAllPost(): NetWorkResults<List<PostDto>> {
        val response = repo.getPosts()
        Log.d("posts", "getAllPost:${response.body()} ")
        return if (response.isSuccessful) NetWorkResults.Success(response)
        else NetWorkResults.Failure.Error(response)
    }
}