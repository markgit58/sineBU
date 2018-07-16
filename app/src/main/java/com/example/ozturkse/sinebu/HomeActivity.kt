package com.example.ozturkse.sinebu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.ozturkse.sinebu.api.TheMovieDbApiService
import com.example.ozturkse.sinebu.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val apiService by lazy {
        TheMovieDbApiService.create()
    }

    private var disposable: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // SET TOOLBAR
        setSupportActionBar(toolbar)

        movies_list.layoutManager = LinearLayoutManager(this)

        getMovies()


    }


    fun getMovies() {
        disposable = apiService.getTopRated()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> displayMovies(result.movies) },
                        { error -> Toast.makeText(this, error.message, Toast.LENGTH_LONG).show() }
                )

    }

    fun displayMovies(movies: List<Movie>?) {
        movies_list.adapter = MyMovieRecyclerViewAdapter(movies)
    }

    interface OnMoviesClickCallback {
        fun onClick(movie: Movie)
    }


}
