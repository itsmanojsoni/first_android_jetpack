package com.example.manojsoni.interview

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.manojsoni.interview.network.Movie


class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
        private val TAG : String = BlankFragment::class.java.simpleName
    }

    private lateinit var viewModel: BlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.movieListLiveData.observe(this, Observer(function = fun(it: List<Movie>?) {

            it?.let {

                Log.d(TAG, "Response in the fragment")
                for (movie in it) {

                    Log.d(TAG, "Movie Name = ${movie.title}")
                }
            }
        }))

        viewModel.loadMovies()
    }

}
