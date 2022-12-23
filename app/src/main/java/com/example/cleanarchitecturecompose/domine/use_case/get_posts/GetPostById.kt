package com.example.cleanarchitecturecompose.domine.use_case.get_posts

import com.example.cleanarchitecturecompose.common.network.NetWorkResults
import com.example.cleanarchitecturecompose.common.network.safeApiCall
import com.example.cleanarchitecturecompose.data.remote.dto.PostDto
import com.example.cleanarchitecturecompose.data.repository.GetPostRepository

class GetPostById(private val repo: GetPostRepository) {

    suspend fun postById(): NetWorkResults<PostDto> = safeApiCall({ getIdPost() }, "unknown error ")


    private suspend fun getIdPost(): NetWorkResults<PostDto> {

        val response = repo.getPostById()

       return if (response.isSuccessful)  NetWorkResults.Success(response) else NetWorkResults.Failure.Error(response)


    }


}