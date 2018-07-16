package com.example.ozturkse.sinebu.detail

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ozturkse.sinebu.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    companion object {
        private val TITLE = "title"
        private val OVERVIEW = "overview"

        fun newIntent(context: Context, title: String, overview: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(TITLE, title)
            intent.putExtra(OVERVIEW, overview)
            return intent
        }
    }

}
