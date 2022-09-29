package com.example.androidrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.FootballViewHolder> {
    private ArrayList<FootballData> footballList;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnItemClickListener;

    public FootballAdapter(Context context, ArrayList<FootballData> footballList){
        mInflater = LayoutInflater.from(context);
        this.footballList = footballList;
    }

    @NonNull
    @Override
    public FootballAdapter.FootballViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.football_list, viewGroup, false);
        return new FootballViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballAdapter.FootballViewHolder footballViewHolder, int position) {
        footballViewHolder.name.setText((footballList.get(position)).getName());
        footballViewHolder.description.setText((footballList.get(position)).getDescription());
        Glide.with(footballViewHolder.itemView)
                .load(footballList.get(position).getImage())
                .override(100, 150)
                .into(footballViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return footballList.size();
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    class FootballViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView image;

        public FootballViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.football_name);
            description = itemView.findViewById(R.id.football_description);
            image = itemView.findViewById(R.id.football_image);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
}
