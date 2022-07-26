package com.example.quickjob.network

import com.example.quickjob.model.PersonModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("?rest_route=/users/v1/all")
    fun getUserList(): Call<MutableList<PersonModel>>
}