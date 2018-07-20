package com.example.ozturkse.sinebu.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.ozturkse.sinebu.R
import com.example.ozturkse.sinebu.R.id.*
import com.example.ozturkse.sinebu.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class SearchResultsListAdapter(private val context: Context, private var movies:List<Movie>?, val clickListener :(Movie)-> Unit) : BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return movies!!.size
    }

    override fun getItem(position: Int): Any {
        return movies!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.item_movie, parent, false)
        val movie = getItem(position) as Movie
        Glide.with(context).load(movie.getPosterUrl()).into(rowView.item_movie_poster)
        rowView.item_movie_poster.setOnClickListener { clickListener(movie)}


        return rowView
    }

    fun updateList(newData: List<Movie>?) {
        movies = newData
        notifyDataSetChanged()
    }
}




