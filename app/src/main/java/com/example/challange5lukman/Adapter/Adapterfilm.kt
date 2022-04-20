package com.example.challange5lukman.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challange5lukman.Model.DatafilmResponseItem
import com.example.challange5lukman.R
import kotlinx.android.synthetic.main.item_filem.view.*

class Adapterfilm(private var onclick : (DatafilmResponseItem)->Unit) : RecyclerView.Adapter<Adapterfilm.ViewHolder>(){

    private var dataFilm : List<DatafilmResponseItem>? = null

    fun setDataFilm(film : List<DatafilmResponseItem>){
        this.dataFilm = film
    }

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.text_title.text = dataFilm!![position].title
        holder.itemView.text_tglfilm.text = dataFilm!![position].releaseDate
        holder.itemView.text_director.text = dataFilm!![position].director

        Glide.with(holder.itemView.context)
            .load(dataFilm!![position].image)
            .into(holder.itemView.img_film)

        holder.itemView.card_film.setOnClickListener {
            onclick(dataFilm!![position])
        }
    }

    override fun getItemCount(): Int {
        if (dataFilm == null){
            return 0
        }else{
            return dataFilm!!.size
        }
    }

}
