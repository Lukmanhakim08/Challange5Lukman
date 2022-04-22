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
import com.example.challange5lukman.Model.Responseuser
import com.example.challange5lukman.ViewModel.ViewModelRegister
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    lateinit var pref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        pref = this.getSharedPreferences("LOGOUT", Context.MODE_PRIVATE)

        tombol_update.setOnClickListener {
            getDataProfile()
        }

        btn_logout.setOnClickListener {
           AlertDialog.Builder(this)
               .setTitle("LOGOUT")
               .setMessage("yakin Mw Logout ....? ")
               .setCancelable(false)
               .setPositiveButton("Ya"){ dialogInterface: DialogInterface, i: Int ->
                   Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()
                   startActivity(Intent(this, LoginActivity::class.java))
               }
               .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                   Toast.makeText(this,"Tidak jadi di hapus", Toast.LENGTH_LONG).show()
               }
               .show()
        }
    }

    fun getDataProfile(){
        val id = "149"
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
        vieModel.UpdteUserApi(id, nmlengkap, username, addres, tgllahir)
    }



    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}