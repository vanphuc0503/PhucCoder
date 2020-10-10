package com.example.buoi7.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buoi7.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private ArrayList<News> data;
    private LayoutInflater inflater;

    public NewsAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public ArrayList<News> getData() {
        return data;
    }

    public void setData(ArrayList<News> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_news, parent, false);
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        holder.bindViews(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null? 0:data.size();
    }


    public class NewsHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle, txtDescription, txtDate, txtUrl;
        private ImageView imNews;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDescription = itemView.findViewById(R.id.txt_description);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtUrl = itemView.findViewById(R.id.txt_link);
            imNews = itemView.findViewById(R.id.im_image);
        }

        public void bindViews(News item) {
            Glide.with(imNews).load(item.getImage()).into(imNews);
            txtTitle.setText(item.getTitle());
            txtDescription.setText(item.getDesc());
            txtUrl.setText(item.getUrl());
            txtDate.setText(item.getPubDate());

        }
    }
}
