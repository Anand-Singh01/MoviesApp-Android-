package com.example.moviesapp.data

data class DataOrException<T, Boolean, Exception>(
    var data:T? = null,
    var isLoading:kotlin.Boolean = false,
    var e:kotlin.Exception? = null
)
