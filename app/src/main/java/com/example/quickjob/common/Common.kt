package com.example.quickjob.common

import com.example.quickjob.network.APIService
import com.example.quickjob.network.Retrofit

object Common {
    private const val BASE_URL = "https://www.quickjob.be/"
    val getApiService: APIService
    get() = Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)
}