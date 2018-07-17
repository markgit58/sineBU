package com.example.ozturkse.sinebu.detail

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ozturkse.sinebu.R
import com.example.ozturkse.sinebu.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupToolbar();

        title = intent.getStringExtra(TITLE)
        val posterUrl = intent.getStringExtra(POSTER)


        movie_name.text = title
        Glide.with(this).load(posterUrl).into(movie_poster)

    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        private val TITLE = "title"
        private val POSTER = "poster"

        private val SUMMARY = "summary"


        fun newIntent(context: Context, movie: Movie): Intent {
            val intent = Intent(context, DetailActivity::class.java)

            val posterUrl = movie.getPosterUrl()
            intent.putExtra(TITLE, movie.title)
            intent.putExtra(POSTER, posterUrl)

            return intent
        }
    }

}
