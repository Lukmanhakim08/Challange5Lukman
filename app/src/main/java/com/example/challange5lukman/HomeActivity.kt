package com.example.challange5lukman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challange5lukman.Adapter.Adapterfilm
import com.example.challange5lukman.ViewModel.ViewModelFilm
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var adapterFilm : Adapterfilm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        adapterFilm = Adapterfilm()
//        rv_film.layoutManager = LinearLayoutManager(this)
//        rv_film.adapter = adapterFilm
        inirecyler()
        getDataFilm()
    }

    fun inirecyler(){
        rv_film.layoutManager = LinearLayoutManager(this)
        adapterFilm = Adapterfilm(){}
        rv_film.adapter = adapterFilm
    }

    fun getDataFilm(){
        val viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)
        viewModel.getLiveFilmObserver().observe(this, Observer {
            if (it != null){
                adapterFilm.setDataFilm(it)
                adapterFilm.notifyDataSetChanged()
            }
        })
        viewModel.makeApiFilm()
    }

    override fun onResume() {
        super.onResume()
        getDataFilm()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}