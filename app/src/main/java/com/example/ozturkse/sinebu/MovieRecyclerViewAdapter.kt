package com.example.ozturkse.sinebu

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ozturkse.sinebu.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

interface OnMoviesClickCallback {
    fun onClick(movie: Movie)
}


class MyMovieRecyclerViewAdapter(val movies: List<Movie>?, val callback: OnMoviesClickCallback) : RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies!![position])

    }

    override fun getItemCount(): Int = movies!!.size

    inner class ViewHolder(val movie_item_view : View) : RecyclerView.ViewHolder(movie_item_view) {

        fun bind(movie: Movie) = with(itemView) {
            item_movie_title.text = movie.title
            Glide.with(context).load(movie.getPosterUrl()).into(item_movie_poster)
        }

    }
}
