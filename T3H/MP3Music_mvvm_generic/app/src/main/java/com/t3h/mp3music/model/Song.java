package com.t3h.mp3music.model;

import android.net.Uri;
import android.provider.MediaStore;

public class Song extends BaseModel {
    @FieldInfo(columnName = MediaStore.Audio.Media._ID)
    private int id;
    @FieldInfo(columnName = MediaStore.Audio.Media.DATA)
    private String data;
    @FieldInfo(columnName = MediaStore.Audio.Media.TITLE)
    private String title;
    @FieldInfo(columnName = MediaStore.Audio.Media.SIZE)
    private int size;
    @FieldInfo(columnName = MediaStore.Audio.Media.DURATION)
    private int duration;
    @FieldInfo(columnName = MediaStore.Audio.Media.ALBUM)
    private String album;
    @FieldInfo(columnName = MediaStore.Audio.Media.ARTIST)
    private String artist;
    @FieldInfo(columnName = MediaStore.Audio.Media.ALBUM_ID)
    private int albumId;

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public int getDuration() {
        return duration;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public int getAlbumId() {
        return albumId;
    }

    @Override
    public Uri getContentUri() {
        return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    }
}
