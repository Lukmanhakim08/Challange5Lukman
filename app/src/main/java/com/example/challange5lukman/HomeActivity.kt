package com.example.challange5lukman

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
    lateinit var sf: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        sf = this.getSharedPreferences("datauser", Context.MODE_PRIVATE)

        sf = getSharedPreferences("datauser", Context.MODE_PRIVATE)
        txt_username.text = "Username, " + sf.getString("email", "")

        img_user.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

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
        sf = this.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        getDataFilm()

        val username = sf.getString("EMAIL", "")
        txt_username.text = username
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}