package com.example.moviestreamingtemplateappseries.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviestreamingtemplateappseries.Interface.MovieItemClickListener;
import com.example.moviestreamingtemplateappseries.model.Movie;
import com.example.moviestreamingtemplateappseries.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyMoviewHolder> {
    public Context context;
    public List<Movie> list;
    MovieItemClickListener movieItemClickListener;

    public MovieAdapter(Context context, List<Movie> list, MovieItemClickListener listener) {
        this.context = context;
        this.list = list;
        movieItemClickListener = listener;
    }

    @NonNull
    @Override
    public MyMoviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new MyMoviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMoviewHolder myMoviewHolder, int i) {
        Movie movie = list.get(i);
        myMoviewHolder.moview_title.setText(movie.getTitle());
        myMoviewHolder.moviewPhoto.setImageResource(list.get(i).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyMoviewHolder extends RecyclerView.ViewHolder {
        ImageView moviewPhoto;
        TextView moview_title;

        public MyMoviewHolder(@NonNull View itemView) {
            super(itemView);

            moviewPhoto = itemView.findViewById(R.id.movie_photo);
            moview_title = itemView.findViewById(R.id.movie_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieItemClickListener.onMovieClick(list.get(getAdapterPosition()),moviewPhoto);
                }
            });
        }
    }
}
