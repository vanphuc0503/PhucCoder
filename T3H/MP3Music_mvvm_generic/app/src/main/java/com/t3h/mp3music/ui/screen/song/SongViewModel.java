package com.t3h.mp3music.ui.screen.song;

import android.content.Context;

import com.t3h.mp3music.model.Album;
import com.t3h.mp3music.model.Song;
import com.t3h.mp3music.ui.base.BaseViewModel;
import com.t3h.mp3music.util.SystemData;

import java.util.ArrayList;

public class SongViewModel extends BaseViewModel {
    private ArrayList<Song> songs;

    public ArrayList<Song> getSong(Context context){
        if(songs==null){
            SystemData data=new SystemData(context);
            songs=data.getData(Song.class);
        }
        return songs;
    }
}
