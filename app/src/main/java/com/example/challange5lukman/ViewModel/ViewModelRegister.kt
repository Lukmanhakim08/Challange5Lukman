package com.example.challange5lukman.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challange5lukman.Model.Detailuser
import com.example.challange5lukman.Model.ResponseRegister
import com.example.challange5lukman.Model.Responseuser
import com.example.challange5lukman.Network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelRegister : ViewModel(){
    lateinit var liveRegister : MutableLiveData<ResponseRegister?>
    lateinit var liveDataLogin : MutableLiveData<Responseuser?>
    lateinit var liveDataLoginBr : MutableLiveData<List<Responseuser>?>
    lateinit var liveDataDetail : MutableLiveData<List<Detailuser>?>

    init {
        liveRegister = MutableLiveData()
        liveDataLogin = MutableLiveData()
        liveDataLoginBr = MutableLiveData()
        liveDataDetail = MutableLiveData()
    }

    fun getliveRegisterObserver() : MutableLiveData<ResponseRegister?> {
        return liveRegister
    }

    fun getLiveLogin() : MutableLiveData<List<Responseuser>?> {
        return liveDataLoginBr
    }

    fun getLiveLoginObserver() : MutableLiveData<Responseuser?>{
        return liveDataLogin
    }

    fun getLiveDetailObserver() : MutableLiveData<List<Detailuser>?>{
        return liveDataDetail
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

    fun PostLoginUser(){
        ApiClient.instance.allUser()
            .enqueue(object : Callback<List<Responseuser>>{
                override fun onResponse(
                    call: Call<List<Responseuser>>,
                    response: Response<List<Responseuser>>
                ) {
                    if (response.isSuccessful){
                        liveDataLoginBr.postValue(response.body())
                    }else{
                        liveDataLoginBr.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<Responseuser>>, t: Throwable) {
                    liveDataLoginBr.postValue(null)
                }

            })
    }

//    fun LoginApi(email: String, password: String){
//        ApiClient.instance.loginUser(email, password)
//            .enqueue(object : Callback<Responseuser>{
//                override fun onResponse(
//                    call: Call<Responseuser>,
//                    response: Response<Responseuser>
//                ) {
//                    if (response.isSuccessful){
//                        liveDataLogin.postValue(response.body())
//                    }else{
//                        liveDataLogin.postValue(null)
//                    }
//                }
//
//                override fun onFailure(call: Call<Responseuser>, t: Throwable) {
//                    liveDataLogin.postValue(null)
//                }
//
//            })
//    }

    fun UpdteUserApi(id: Int, complete_name: String, username: String, address: String, dateofbirth: String){
        ApiClient.instance.updateUser(id, complete_name, username, address, dateofbirth)
            .enqueue(object : Callback<Responseuser>{
                override fun onResponse(
                    call: Call<Responseuser>,
                    response: Response<Responseuser>
                ) {
                    if (response.isSuccessful){
                        liveDataLogin.postValue(response.body())
                    }else{
                        liveDataLogin.postValue(null)
                    }
                }

                override fun onFailure(call: Call<Responseuser>, t: Throwable) {
                    liveDataLogin.postValue(null)
                }

            })
    }

    fun DetailUserApi(id: Int){
        ApiClient.instance.detailUser(id)
            .enqueue(object : Callback<List<Detailuser>>{
                override fun onResponse(
                    call: Call<List<Detailuser>>,
                    response: Response<List<Detailuser>>
                ) {
                    if (response.isSuccessful){
                        liveDataDetail.postValue(response.body())
                    }else{
                        liveDataDetail.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<Detailuser>>, t: Throwable) {
                    liveDataDetail.postValue(null)
                }

            })
    }

}