package com.example.cleanarchitecturecompose.common.network

import okhttp3.Headers
import okhttp3.ResponseBody
import retrofit2.Response

sealed class NetWorkResults<out T> {
    data class Success<T>(val response: Response<T>): NetWorkResults<T>() {
        val statusCode = response.code()
        private val data:T?= response.body()
        val header: Headers = response.headers()
        override fun toString(): String = "network results success $data"
    }
    sealed class Failure{
        data class Error<T>(val response:Response<T>):NetWorkResults<T>() {
            val statusCode = response.code()
            private val errorBody:ResponseBody? =response.errorBody()
            val header:Headers = response.headers()
            override fun toString(): String = " Error response - $errorBody"
        }
        data class Exception<T>(val exception:Throwable):NetWorkResults<T>(){
            private val message = exception.localizedMessage
            override fun toString(): String = "exception - $message"

        }

    }
}
