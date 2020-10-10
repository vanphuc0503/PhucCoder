package com.t3h.mp3music.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;

import com.t3h.mp3music.MediaController;
import com.t3h.mp3music.R;
import com.t3h.mp3music.model.Song;

import java.util.ArrayList;

public class MP3Service extends Service {

    private MediaController controller;
    private RemoteViews remoteViews;
    private final String ACTION_NEXT = "action.NEXT";
    private final String ACTION_PREV = "action.PREV";
    private final String ACTION_PLAY = "action.PLAY";
    private final String ACTION_CLOSE = "action.CLOSE";
    private MutableLiveData<MediaController> liveController = new MutableLiveData<>();
    private boolean isRunning;

    @Override
    public void onCreate() {
        super.onCreate();
        initRemoteViews();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_CLOSE);
        filter.addAction(ACTION_PLAY);
        filter.addAction(ACTION_PREV);
        filter.addAction(ACTION_NEXT);
        registerReceiver(receiver, filter);
    }

    private void initRemoteViews() {
        remoteViews = new RemoteViews(getPackageName(), R.layout.ui_notification);
        registerAction(R.id.im_close, ACTION_CLOSE);
        registerAction(R.id.im_next, ACTION_NEXT);
        registerAction(R.id.im_prev, ACTION_PREV);
        registerAction(R.id.im_play, ACTION_PLAY);

    }

    private void registerAction(@IdRes int id, String action) {
        Intent intent = new Intent(action);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(id, pendingIntent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return new MP3Binder(this);
    }

    // TODO: 7/29/2020
    public void pushNotify(Song song) {
        Intent intent = new Intent(this, getClass());
        startService(intent);
        String channelId = "MP3Channel";
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelId, NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(channel);
        }
        remoteViews.setTextViewText(R.id.tv_song, song.getTitle());
        remoteViews.setTextViewText(R.id.tv_artist, song.getArtist());
        if (controller.isPlaying()) {
            remoteViews.setImageViewResource(R.id.im_play, R.drawable.ic_pause);
        } else {
            remoteViews.setImageViewResource(R.id.im_play, R.drawable.ic_play);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this, channelId
        );

        builder.setSmallIcon(R.drawable.ic_song);
        builder.setCustomContentView(remoteViews);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        startForeground(121, builder.build());
    }

    public void setData(final ArrayList<Song> songs) {
        if (controller == null) {
            controller = new MediaController(songs, this) {
                @Override
                public void create(int index) {
                    super.create(index);
                    if (isRunning == false){
                        isRunning = true;
                        Thread t = new Thread(run);
                        t.start();
                    }
                }

                @Override
                public void pause() {
                    super.pause();
                    pushNotify(songs.get(index));
                }

                @Override
                public void start() {
                    super.start();
                    pushNotify(songs.get(index));
                }
            };
        }
    }

    private Runnable run = new Runnable() {
        @Override
        public void run() {
            while (true){
                liveController.postValue(controller);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public MutableLiveData<MediaController> getLiveController() {
        return liveController;
    }

    public MediaController getController() {

        return controller;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (controller != null){
            controller.release();
        }
        unregisterReceiver(receiver);
    }

    public class MP3Binder extends Binder {
        private MP3Service service;

        public MP3Binder(MP3Service service) {
            this.service = service;
        }

        public MP3Service getService() {
            return service;
        }
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case ACTION_CLOSE:
                    stopForeground(true);
                    controller.release();
                    controller = null;
                    liveController.postValue(null);
                    stopSelf();
                    break;
                case ACTION_NEXT:
                    controller.change(1);
                    break;
                case ACTION_PREV:
                    controller.change(-1);
                    break;
                case ACTION_PLAY:
                    if (controller.isPlaying()) {
                        controller.pause();
                    } else {
                        controller.start();
                    }
                    break;
            }
        }
    };
}
