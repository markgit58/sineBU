package com.example.ozturkse.sinebu.listing

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ozturkse.sinebu.R
import com.example.ozturkse.sinebu.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*



class MyMovieRecyclerViewAdapter(val movies: List<Movie>?) : RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder>() {

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
            item_movie_rating.text = movie.rating.toString()
            item_movie_release_date.text = movie.releaseDate!!.split("-")[0]

            Glide.with(context).load(movie.getPosterUrl()).into(item_movie_poster)
        }

    }
}
