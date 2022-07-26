package com.example.quickjob.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.quickjob.model.PersonModel
import com.example.quickjob.repository.MainRepository

class MainActivityViewModel: ViewModel() {
    private val mainRepository: MainRepository
    val getUserList: LiveData<MutableList<PersonModel>>
    get() = mainRepository.getPersonModelLiveData

    init {
        mainRepository = MainRepository()
    }
}