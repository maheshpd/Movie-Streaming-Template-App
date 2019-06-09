package com.example.moviestreamingtemplateappseries.Interface;

import android.widget.ImageView;

import com.example.moviestreamingtemplateappseries.model.Movie;

public interface MovieItemClickListener {
    void onMovieClick(Movie movie, ImageView movieImage); // we will need the imageview to make the shared animation between the two activity
}
