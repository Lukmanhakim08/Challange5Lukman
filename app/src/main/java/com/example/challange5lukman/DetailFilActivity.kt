package com.example.challange5lukman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.challange5lukman.Model.DatafilmResponseItem
import kotlinx.android.synthetic.main.activity_detail_fil.*

class DetailFilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_fil)

        val datafilm = intent.getParcelableExtra<DatafilmResponseItem>("DetailFilm")
        text_detailjudu.text = datafilm?.title
        text_detailtgl.text = datafilm?.releaseDate
        detail_director.text = datafilm?.director

        Glide.with(applicationContext)
            .load(datafilm?.image)
            .into(img_detail)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}