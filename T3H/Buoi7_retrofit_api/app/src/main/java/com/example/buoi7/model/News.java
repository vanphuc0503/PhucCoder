package com.example.buoi7.model;

import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String desc;

    @SerializedName("url")
    private String url;

    @SerializedName("urlToImage")
    private String image;

    @SerializedName("publishedAt")
    private String pubDate;

    public News(String title, String desc, String url, String pubDate) {
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getPubDate() {
        return pubDate;
    }
}
