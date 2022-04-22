package com.example.challange5lukman

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.challange5lukman.Model.Detailuser
import com.example.challange5lukman.Model.Responseuser
import com.example.challange5lukman.Network.ApiClient
import com.example.challange5lukman.ViewModel.ViewModelRegister
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    lateinit var pref : SharedPreferences
    lateinit var listUser : List<Detailuser>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        pref = getSharedPreferences("datauser", Context.MODE_PRIVATE)

        getdataProfile()

        tombol_update.setOnClickListener {
//            val id = pref.getString("id", "").toString()
//            val name = edt_usnameprofl.text.toString()
//            val nmlengkap = edt_nmlengkap.text.toString()
//            val tgl = edt_tgllahir.text.toString()
//            val alamat = edt_alamat.text.toString()
//            updateDataUser(id.toInt(), name, nmlengkap, tgl, alamat)
//            finish()
            UpdateDateProfile()
        }

        btn_logout.setOnClickListener {
           AlertDialog.Builder(this)
               .setTitle("LOGOUT")
               .setMessage("yakin Mw Logout ....? ")
               .setCancelable(false)
               .setPositiveButton("Ya"){ dialogInterface: DialogInterface, i: Int ->
                   pref = getSharedPreferences("datauser", Context.MODE_PRIVATE)
                   val logout = pref.edit()
                   logout.clear()
                   logout.apply()
                   startActivity(Intent(this, LoginActivity::class.java))
                   finish()
               }
               .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                   Toast.makeText(this,"Tidak jadi di logout", Toast.LENGTH_LONG).show()
               }
               .show()
        }
    }

    fun getdataProfile(){
        val id = pref.getString("id", "")
        val viewModel = ViewModelProvider(this).get(ViewModelRegister::class.java)
        viewModel.DetailUserApi(id!!.toInt())
        viewModel.getLiveDetailObserver().observe(this, Observer {
            if (it != null){
                listUser = it
                initData(listUser)
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun initData(userDataList : List<Detailuser>){
        for (i in userDataList.indices){
            edt_usnameprofl.setText(userDataList[i].username)
            edt_nmlengkap.setText(userDataList[i].completeName)
            edt_alamat.setText(userDataList[i].address)
            edt_tgllahir.setText(userDataList[i].dateofbirth)

        }
    }

    fun UpdateDateProfile(){
        val id = pref.getString("id", "").toString()
        val nmlengkap = edt_nmlengkap.text.toString()
        val username = edt_usnameprofl.text.toString()
        val addres = edt_alamat.text.toString()
        val tgllahir = edt_tgllahir.text.toString()

        val vieModel= ViewModelProvider(this).get(ViewModelRegister::class.java)
        vieModel.getLiveLoginObserver().observe(this, Observer {
            if (it != null){
                Toast.makeText(this, "Gagal update Data", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Berhasil update Data", Toast.LENGTH_SHORT).show()
            }
        })
        vieModel.UpdteUserApi(id.toInt(), nmlengkap, username, addres, tgllahir)
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}