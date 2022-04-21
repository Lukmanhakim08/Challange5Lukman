package com.example.challange5lukman.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challange5lukman.Network.ApiClient
import mumtaz.binar.challangechapterlima.model.Responseuser

class ViewModelUser : ViewModel() {
    var liveDataUser : MutableLiveData<Responseuser> = MutableLiveData()
    fun getLiveDataObserver() : MutableLiveData<Responseuser>{
        return liveDataUser
    }
//
//    fun setLiveDataUserApi(){
//        ApiClient.in
//    }
}