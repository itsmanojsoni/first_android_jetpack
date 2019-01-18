package com.example.manojsoni.interview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.manojsoni.interview.network.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();

    private final List<Movie> movieList = new ArrayList<>();

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_row, parent, false);

        return new MovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "on Bind View Holder");
        holder.onBind(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "movie lsit size = "+movieList.size());
        return movieList.size();
    }

    public void setMovieList(List<Movie> movies) {
        Log.d(TAG, "set Movie Lsit");
        movieList.clear();
        movieList.addAll(movies);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView movieIv;
        private TextView movieTitleTv;


        public ViewHolder(View itemView) {
            super(itemView);
            movieIv = itemView.findViewById(R.id.movieIv);
            movieTitleTv = itemView.findViewById(R.id.movieTitleTv);
        }

        public void onBind(Movie movie) {
            Glide.with(itemView.getContext())
                    .load(movie.getImage())
                    .into(movieIv);
            movieTitleTv.setText(movie.getTitle());
        }
    }
}
