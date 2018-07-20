package com.example.ozturkse.sinebu.listing

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ozturkse.sinebu.R
import kotlinx.android.synthetic.main.activity_detail.*


class LicenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_licence)

        setSupportActionBar(activity_detail_toolbar)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, LicenceActivity::class.java)
            return intent
        }
    }
}
