package com.vgubert.loockjson.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vgubert.loockjson.MAIN
import com.vgubert.loockjson.R
import com.vgubert.loockjson.models.MovieItemModel
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private var listMovies = emptyList<MovieItemModel>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.item_title.text = listMovies[position].title
        holder.itemView.item_date.text = listMovies[position].release_date

        Glide.with(MAIN)
            .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${listMovies[position].poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.item_img)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setList(list: List<MovieItemModel>) {
        listMovies = list
        notifyDataSetChanged()
    }
}