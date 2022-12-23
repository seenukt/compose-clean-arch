package com.example.cleanarchitecturecompose.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturecompose.common.network.NetWorkResults
import com.example.cleanarchitecturecompose.corutiens.CoroutinesManager
import com.example.cleanarchitecturecompose.data.remote.dto.PostDto
import com.example.cleanarchitecturecompose.data.repository.GetPostRepository
import com.example.cleanarchitecturecompose.domine.use_case.get_post.GetAllPosts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class DummyViewModel(private val coroutines: CoroutinesManager, private val repo: GetAllPosts) :
    ViewModel() {

    lateinit var listResponse: Response<List<PostDto>>


    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repo.getAllPosts()
            withContext(Dispatchers.Main) {
                when (data) {
                    is NetWorkResults.Success -> {
                        val post = data.response.body()
                        Log.d("post", "getDataSize:${post?.size} ")
                        Log.d("post", "getData:${post?.get(1)} ")
                    }
                    is NetWorkResults.Failure.Error -> {

                    }
                    is NetWorkResults.Failure.Exception -> {

                    }
                }
                Log.d("data", "getData:${data}")
//           listResponse =data
            }
        }
    }
}