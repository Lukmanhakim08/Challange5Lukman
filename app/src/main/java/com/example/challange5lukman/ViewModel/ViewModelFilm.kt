package com.example.challange5lukman.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challange5lukman.Model.DatafilmResponseItem
import com.example.challange5lukman.Network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelFilm : ViewModel() {
    lateinit var liveDataFilm : MutableLiveData<List<DatafilmResponseItem>?>

    init {
        liveDataFilm = MutableLiveData()
    }

    fun getLiveFilmObserver() : MutableLiveData<List<DatafilmResponseItem>?> {
        return liveDataFilm
    }

    fun makeApiFilm(){
        ApiClient.instance.GetDatafilm()
            .enqueue(object : Callback<List<DatafilmResponseItem>>{
                override fun onResponse(
                    call: Call<List<DatafilmResponseItem>>,
                    response: Response<List<DatafilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataFilm.postValue(response.body())
                    }else{
                        liveDataFilm.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<DatafilmResponseItem>>, t: Throwable) {
                    liveDataFilm.postValue(null)
                }

            })
    }
}