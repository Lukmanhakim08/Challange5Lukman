package com.example.challange5lukman.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challange5lukman.Model.DatafilmResponseItem
import com.example.challange5lukman.Model.ResponseRegister
import com.example.challange5lukman.Network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelRegister : ViewModel(){
    lateinit var liveRegister : MutableLiveData<ResponseRegister?>

    init {
        liveRegister = MutableLiveData()
    }

    fun getliveRegisterObserver() : MutableLiveData<ResponseRegister?> {
        return liveRegister
    }

    fun RegisterApi(username: String, email: String, password: String){
        ApiClient.instance.addRegister(username, email, password)
            .enqueue(object : Callback<ResponseRegister> {
                override fun onResponse(
                    call: Call<ResponseRegister>,
                    response: Response<ResponseRegister>
                ) {
                    if (response.isSuccessful){
                        liveRegister.postValue(response.body())
                    }else{
                        liveRegister.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                    liveRegister.postValue(null)
                }
            })
    }

}