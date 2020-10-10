package com.t3h.mp3music.ui.screen.artist;

import android.content.Context;

import com.t3h.mp3music.model.Album;
import com.t3h.mp3music.model.Artist;
import com.t3h.mp3music.ui.base.BaseViewModel;
import com.t3h.mp3music.util.SystemData;

import java.util.ArrayList;

public class ArtistViewModel extends BaseViewModel {
    private ArrayList<Artist> artists;

    public ArrayList<Artist> getArtist(Context context){
        if(artists==null){
            SystemData data=new SystemData(context);
            artists=data.getData(Artist.class);
        }
        return artists;
    }
}
