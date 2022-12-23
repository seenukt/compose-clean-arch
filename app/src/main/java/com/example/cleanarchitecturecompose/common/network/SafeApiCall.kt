package com.example.cleanarchitecturecompose.common.network

suspend fun<T:Any>safeApiCall(call:suspend ()->NetWorkResults<T>,errorMessage:String):NetWorkResults<T>{

   return try {
        call()
    }catch (e:Exception){
        NetWorkResults.Failure.Exception(Throwable(errorMessage,e))
    }
}