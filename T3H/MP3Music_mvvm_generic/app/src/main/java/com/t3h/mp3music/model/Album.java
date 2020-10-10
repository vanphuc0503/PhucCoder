package com.t3h.mp3music.model;

import android.net.Uri;
import android.provider.MediaStore;

public class Album extends BaseModel {
    @FieldInfo(columnName = MediaStore.Audio.Albums._ID)
    private int id;

    @FieldInfo(columnName = MediaStore.Audio.Albums.ALBUM)
    private String name;

    @FieldInfo(columnName = MediaStore.Audio.Albums.NUMBER_OF_SONGS)
    private int numOfSong;

    @FieldInfo(columnName = MediaStore.Audio.Albums.ARTIST)
    private String artist;

    @FieldInfo(columnName = MediaStore.Audio.Albums.ARTIST_ID)
    private int artistId;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumOfSong() {
        return numOfSong;
    }

    public String getArtist() {
        return artist;
    }

    public int getArtistId() {
        return artistId;
    }

    @Override
    public Uri getContentUri() {
        return MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
    }
}
