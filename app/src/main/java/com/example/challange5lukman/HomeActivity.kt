package com.example.challange5lukman

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.challange5lukman.Adapter.Adapterfilm
import com.example.challange5lukman.Model.DatafilmResponseItem
import com.example.challange5lukman.ViewModel.ViewModelFilm
import kotlinx.android.synthetic.main.activity_detail_fil.*
import kotlinx.android.synthetic.main.activity_home.*
import mumtaz.binar.challangechapterlima.model.ResponseLogin
import mumtaz.binar.challangechapterlima.model.Responseuser

class HomeActivity : AppCompatActivity() {

    lateinit var adapterFilm : Adapterfilm
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val detailUser = intent.getParcelableExtra<Responseuser>("DetailUser")
        img_user.setOnClickListener {
            val parsing = Intent(this, ProfileActivity::class.java)
            parsing.putExtra("DetailUser", detailUser)
            startActivity(parsing)
        }
        sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)

        getDataFilm()
        inirecyler()
    }
//
    fun inirecyler(){
        rv_film.layoutManager = LinearLayoutManager(this)
        adapterFilm = Adapterfilm(){
            val pindah = Intent(this, DetailFilActivity::class.java)
            pindah.putExtra("DetailFilm", it)
            startActivity(pindah)
        }
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