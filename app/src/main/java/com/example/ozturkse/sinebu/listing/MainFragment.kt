package com.example.ozturkse.sinebu.listing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ozturkse.sinebu.R
import com.example.ozturkse.sinebu.api.TheMovieDbApiService
import com.example.ozturkse.sinebu.detail.DetailActivity
import com.example.ozturkse.sinebu.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment() : Fragment() {
    private val apiService by lazy {
        TheMovieDbApiService.create()
    }

    private var data : List<Movie>? = emptyList()


    private var disposable: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sectionNumber = arguments!!.getInt(ARG_SECTION_NUMBER)
        when (sectionNumber) {
            0 -> getNowPlayingMovies()
            1 -> getPopularMovies()
            2 -> getTopRatedMovies()
            3 -> getUpcomingMovies()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()


    }

    private fun initLayout() {
        val layoutManager = GridLayoutManager(context, 2)
        movies_list.layoutManager = layoutManager
        movies_list.adapter = MyMovieRecyclerViewAdapter(data, { movie: Movie -> movieItemClicked(movie) })


    }

    fun getUpcomingMovies() {
        disposable = apiService.getUpcomingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> displayMovies(result.movies) },
                        { error -> Toast.makeText(context, error.message, Toast.LENGTH_LONG).show() }
                )
    }

    fun getTopRatedMovies() {
        disposable = apiService.getTopRated()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> displayMovies(result.movies) },
                        { error -> Toast.makeText(context, error.message, Toast.LENGTH_LONG).show() }
                )
    }

    fun getPopularMovies() {
        disposable = apiService.getPopular()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> displayMovies(result.movies) },
                        { error -> Toast.makeText(context, error.message, Toast.LENGTH_LONG).show() }
                )
    }

    fun getNowPlayingMovies() {
        disposable = apiService.getNowPlayingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> displayMovies(result.movies) },
                        { error -> Toast.makeText(context, error.message, Toast.LENGTH_LONG).show() }
                )
    }

    fun displayMovies(movies: List<Movie>?) {
        data = movies
        movies_list.adapter!!.notifyDataSetChanged()
    }

    private fun movieItemClicked(movie: Movie) {
        getMovieDetails(movie)
    }


    fun getMovieDetails(movie: Movie) {
        disposable = apiService.getMovie(movie.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> displayMovieDetails(result) },
                        { error -> Toast.makeText(context, error.message, Toast.LENGTH_LONG).show() }
                )
    }

    fun displayMovieDetails(movie: Movie) {
        startActivity(DetailActivity.newIntent(context!!, movie))
    }

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}