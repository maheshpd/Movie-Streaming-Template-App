package com.example.moviestreamingtemplateappseries.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.moviestreamingtemplateappseries.R;
import com.example.moviestreamingtemplateappseries.adapter.MovieAdapter;
import com.example.moviestreamingtemplateappseries.adapter.SliderPagerAdapter;
import com.example.moviestreamingtemplateappseries.Interface.MovieItemClickListener;
import com.example.moviestreamingtemplateappseries.model.Movie;
import com.example.moviestreamingtemplateappseries.model.Slide;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;

    private RecyclerView MoviesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);


        //Prepare a list of lides...
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2, "Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide1, "Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2, "Slide Title \nmore text here"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);
        sliderpager.setAdapter(adapter);

        //Setup time
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(), 3000, 5000);
        indicator.setupWithViewPager(sliderpager, true);

        //RecyclerView setup
        //init data
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Moana", R.drawable.moana,R.drawable.spidercover));
        list.add(new Movie("Block P", R.drawable.blackp,R.drawable.spidercover));
        list.add(new Movie(" The Martian", R.drawable.themartian));
        list.add(new Movie("Moview2", R.drawable.mov2));
        list.add(new Movie("Moview2", R.drawable.mov2));
        list.add(new Movie("Moview2", R.drawable.mov2));
        list.add(new Movie("Moview2", R.drawable.mov2));

        MovieAdapter movieAdapter = new MovieAdapter(this, list,this);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        MoviesRV.setHasFixedSize(true);
        MoviesRV.setAdapter(movieAdapter);


    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImage) {
        //here we send movie information to detail activity
        //also we ll create the transition animation between the two activity

        Intent intent = new Intent(this, MovieDetailsActivity.class);
        //send movie information to deatilActivity
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());
        //lets create the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                                                                    movieImage,"sharedName");
        startActivity(intent,options.toBundle());

        //i ll make a simple test to see if the click works
        Toast.makeText(this, "click working "+movie.getTitle(), Toast.LENGTH_SHORT).show();

    }

    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem() < lstSlides.size() - 1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem() + 1);
                    } else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }
}
