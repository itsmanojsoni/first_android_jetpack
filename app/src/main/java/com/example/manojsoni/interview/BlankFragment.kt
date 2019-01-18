package com.example.manojsoni.interview

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manojsoni.interview.network.Movie
import kotlinx.android.synthetic.main.blank_fragment.*

class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
        private val TAG: String = BlankFragment::class.java.simpleName
    }

    private lateinit var viewModel: BlankViewModel
    private lateinit var movieListAdapter : ItemAdapter

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
                movieListAdapter.update(it)
            }
        }))

        viewModel.loadMovies()
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieListAdapter = ItemAdapter()

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = movieListAdapter
    }

}
