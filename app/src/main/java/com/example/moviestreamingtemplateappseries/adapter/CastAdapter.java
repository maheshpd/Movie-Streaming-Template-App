package com.example.moviestreamingtemplateappseries.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.moviestreamingtemplateappseries.R;
import com.example.moviestreamingtemplateappseries.model.Cast;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    Context mContext;
    List<Cast> mData;

    public CastAdapter(Context mContext, List<Cast> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cast_item,viewGroup,false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder castViewHolder, int i) {

        Glide.with(mContext).load(mData.get(i).getImg_link()).into(castViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cast_img);
        }
    }
}
