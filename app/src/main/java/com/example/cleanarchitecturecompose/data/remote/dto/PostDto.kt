package com.example.cleanarchitecturecompose.data.remote.dto

import com.example.cleanarchitecturecompose.domine.model.AllPost
import com.google.gson.annotations.SerializedName


data class PostDto(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)
fun PostDto.toAllPost(): AllPost {
   return AllPost(title = title, body = body)
}