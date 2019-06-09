package com.example.moviestreamingtemplateappseries.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviestreamingtemplateappseries.R;
import com.example.moviestreamingtemplateappseries.adapter.CastAdapter;
import com.example.moviestreamingtemplateappseries.model.Cast;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView movieThumbnailImg,MovieCoverImg;
    private TextView tv_title,tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvCast;
    private RecyclerView.Adapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //init view
        initViews();

        setupRvCast();

    }

    private void setupRvCast() {
        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("name",R.drawable.moana));
        mdata.add(new Cast("name",R.drawable.moana));
        mdata.add(new Cast("name",R.drawable.moana));
        mdata.add(new Cast("name",R.drawable.moana));

        castAdapter = new CastAdapter(this,mdata);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        RvCast.setHasFixedSize(true);
        castAdapter.notifyDataSetChanged();

    }

    private void initViews() {
        String movieTitle = getIntent().getExtras().getString("title");
        int imageCover = getIntent().getExtras().getInt("imgCover");
        int movieResource = getIntent().getExtras().getInt("imgURL");

        movieThumbnailImg = findViewById(R.id.details_movie_img);
        MovieCoverImg = findViewById(R.id.detail_movie_cover_img);
        tv_title = findViewById(R.id.detail_movie_title);
        play_fab = findViewById(R.id.play_fab);
        RvCast = findViewById(R.id.rv_cast);

        Glide.with(this).load(movieResource).into(movieThumbnailImg);
//        movieThumbnailImg.setImageResource(movieResource);
        Glide.with(this).load(imageCover).into(MovieCoverImg);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);

        //setup animation
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
    }
}
