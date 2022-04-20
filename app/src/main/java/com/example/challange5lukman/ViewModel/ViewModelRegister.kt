package com.example.challange5lukman.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challange5lukman.Model.ResponseRegister

class ViewModelRegister : ViewModel(){
    lateinit var liveRegister : MutableLiveData<ResponseRegister>

    init {
        liveRegister = MutableLiveData()
    }

    fun getliveRegisterObserver() : MutableLiveData<ResponseRegister>{
        return liveRegister
    }

}