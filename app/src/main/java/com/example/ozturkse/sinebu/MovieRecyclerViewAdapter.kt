package com.example.ozturkse.sinebu

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ozturkse.sinebu.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyMovieRecyclerViewAdapter(val movies: List<Movie>?) : RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies!![position])

    }

    override fun getItemCount(): Int = movies!!.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        fun bind(movie: Movie) = with(itemView) {
            item_movie_title.text = movie.title
            Glide.with(context).load(movie.getPosterUrl()).into(item_movie_poster)
        }

    }
}
