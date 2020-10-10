package com.example.buoi7.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsResponse {
    @SerializedName("articles")
    private ArrayList<News> arrNews;

    public ArrayList<News> getArrNews() {
        return arrNews;
    }
}
