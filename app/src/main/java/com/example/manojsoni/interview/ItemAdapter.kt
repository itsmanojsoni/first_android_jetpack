package com.example.manojsoni.interview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manojsoni.interview.network.Movie


class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private val items = ArrayList<Movie>()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemNameTv: TextView = itemView.findViewById(R.id.movieTitleTv)
        private val movieIv : ImageView = itemView.findViewById(R.id.movieIv)
        fun bind(movie: Movie) {
            itemNameTv.text = movie.title

            Glide.with(itemView.context)
                .load(movie.image)
                .into(movieIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update(newItems: List<Movie>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
