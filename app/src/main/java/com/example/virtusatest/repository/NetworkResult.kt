package com.example.virtusatest.repository

sealed class NetworkResult<T>(val data:T?=null,val errorMessage:String?=null){
    class Success<T>(data: T?=null):NetworkResult<T>(data=data)
    class Error<T>(errorMessage: String?):NetworkResult<T>(errorMessage = errorMessage)
    class Loading<T>:NetworkResult<T>()
}
