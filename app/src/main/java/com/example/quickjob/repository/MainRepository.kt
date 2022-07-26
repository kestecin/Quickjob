package com.example.quickjob.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.quickjob.common.Common
import com.example.quickjob.model.PersonModel
import com.example.quickjob.network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    private val apiService: APIService

    companion object{
        private const val TAG = "MainRepository"
    }

    init {
        apiService = Common.getApiService
    }

    val getPersonModelLiveData: MutableLiveData<MutableList<PersonModel>>
    get() {
        val data: MutableLiveData<MutableList<PersonModel>> =
            MutableLiveData<MutableList<PersonModel>>()
        apiService.getUserList().enqueue(object : Callback<MutableList<PersonModel>>{
            override fun onResponse(
                call: Call<MutableList<PersonModel>>,
                response: Response<MutableList<PersonModel>>
            ) {
                Log.e(TAG,"onResponse: " + response.code())
                if (response.isSuccessful){
                    data.value = response.body()
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<MutableList<PersonModel>>, t: Throwable) {
                Log.e(TAG,"onResponse: " + t.message)
                data.value = null
            }
        })
        return data
    }
}