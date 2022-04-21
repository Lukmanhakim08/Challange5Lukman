package com.example.challange5lukman

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.challange5lukman.Model.Responseuser
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val getUser = intent.getParcelableExtra<Responseuser>("UpdateUser")
        edt_nmlengkap.setText(getUser?.completeName)
        edt_usnameprofl.setText(getUser?.username)
        edt_email.setText(getUser?.email)
        edt_alamat.setText(getUser?.address)
    }

    private fun logout(){
        AlertDialog.Builder(this)
            .setTitle("LOGOUT")
            .setMessage("Yakin Ingin Logout")
            .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }.setPositiveButton("Ya"){ dialogInterface: DialogInterface, i: Int ->
                val datauser = intent.getParcelableExtra<Responseuser>("LOGIN")
                datauser.apply {  }
                val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                finish()
            }
    }
}