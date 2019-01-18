package com.example.manojsoni.interview.network

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manojsoni.interview.R

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private val movieList  = ArrayList<Movie>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemNameTv: TextView = itemView.findViewById(R.id.movieTitleTv)
        private val movieIv : ImageView = itemView.findViewById(R.id.movieIv)
        fun bind(movie: Movie) {

            Log.d("MovieViewHolder", "bind")
            itemNameTv.text = movie.title

            Glide.with(itemView.context)
                .load(movie.image)
                .into(movieIv)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row, parent, false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieListAdapter.ViewHolder, position: Int) {
        Log.d(TAG, "on Bind View Holder and position = $position")
    }


    fun setData(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged();
        Log.d(TAG, "Set Data")
    }

    companion object {
        private val  TAG = MovieListAdapter::class.java.simpleName
    }

}