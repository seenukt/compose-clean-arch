package com.example.cleanarchitecturecompose.data.repository

import com.example.cleanarchitecturecompose.common.network.NetWorkResults
import com.example.cleanarchitecturecompose.data.remote.ApiIInterface
import com.example.cleanarchitecturecompose.data.remote.dto.PostDto
import com.example.cleanarchitecturecompose.domine.repository.PostRepository
import retrofit2.Response

class GetPostRepository( private val api:ApiIInterface): PostRepository {
    override suspend fun getPosts(): Response<List<PostDto>> {

        //        Log.d("post", "getPosts:${data.body()}")
        return api.getPosts()
//
//        safeApiCall(
//        call =  { getAllPost() },"Failure Error"
//     )
    }

    override suspend fun getPostById(): Response<PostDto> {
   return api.getPost(1)

//        safeApiCall({getIdPosts()},"failure error")
    }



    private suspend fun getIdPosts(): NetWorkResults<PostDto> {
        val response = api.getPost(1)
        return if (response.isSuccessful) NetWorkResults.Success(response)
        else NetWorkResults.Failure.Error(response)
    }



}