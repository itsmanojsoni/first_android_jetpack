package com.example.manojsoni.interview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manojsoni.interview.network.Movie


class ItemAdapter (val listener : OnItemClicked): RecyclerView.Adapter<ItemAdapter.MovieViewHolder>() {

    private val items = ArrayList<Movie>()

    private val TAG = ItemAdapter::class.java.simpleName

    interface OnItemClicked {
        fun onItemClicked(movie: Movie)
    }


    class MovieViewHolder(itemView: View, listener: OnItemClicked) : RecyclerView.ViewHolder(itemView) {

        private val itemNameTv: TextView = itemView.findViewById(R.id.movieTitleTv)
        private val movieIv : ImageView = itemView.findViewById(R.id.movieIv)

        private lateinit var movie : Movie

        init {
            itemView.setOnClickListener {

                listener.onItemClicked(movie)
            }
        }

        fun bind(item: Movie) {
            itemNameTv.text = item.title
            movie = item

            Glide.with(itemView.context)
                .load(item.image)
                .into(movieIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        Log.d(TAG, "on Create View Holder")
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row, parent, false)

        return MovieViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Log.d(TAG, "on BInd View Holder and position is $position")
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
//        Log.d(TAG, "Items size = ${items.size}")
        return items.size
    }

    fun update(newItems: List<Movie>) {
        Log.d(TAG, "update and movies size = ${newItems.size}")
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()

    }
}
