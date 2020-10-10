package com.t3h.mp3music.ui.screen.album;

import android.content.Context;
import com.t3h.mp3music.model.Album;
import com.t3h.mp3music.ui.base.BaseViewModel;
import com.t3h.mp3music.util.SystemData;
import java.util.ArrayList;

public class AlbumViewModel extends BaseViewModel {
    private ArrayList<Album> albums;

    public ArrayList<Album> getAlbum(Context context){
        if(albums==null){
            SystemData data=new SystemData(context);
            albums=data.getData(Album.class);
        }
        return albums;
    }
}
