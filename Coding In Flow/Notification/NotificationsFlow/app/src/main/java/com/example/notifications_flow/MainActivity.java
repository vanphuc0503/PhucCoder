package com.example.notifications_flow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.EditText;

import static com.example.notifications_flow.App.CHANNEL_1_ID;
import static com.example.notifications_flow.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    private MediaSessionCompat mediaSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);

        mediaSession = new MediaSessionCompat(this, "tag");
    }

    public void sendOnChannel1(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);

        /*Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage", message);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,
                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);*/

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lotti);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(picture)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(picture)
                        .bigLargeIcon(null))
//                .setStyle(new NotificationCompat.BigTextStyle()
//                        .bigText(getString(R.string.long_dummy_tetx))
//                        .setBigContentTitle("Big Content Title")
//                        .setSummaryText("Summer Text"))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
//                .addAction(R.mipmap.ic_launcher, "Toast", actionIntent)
                .build();

        notificationManager.notify(1, notification);
    }

    public void sendOnChannel2(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Bitmap artwork = BitmapFactory.decodeResource(getResources(), R.drawable.lotti);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(artwork)
                .addAction(R.drawable.ic_dislike, "Dislike", null)
                .addAction(R.drawable.ic_previous, "Previous", null)
                .addAction(R.drawable.ic_pause, "Pause", null)
                .addAction(R.drawable.ic_next, "Next", null)
                .addAction(R.drawable.ic_like, "Like", null)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(1, 2, 3)
                        .setMediaSession(mediaSession.getSessionToken()))
                .setSubText("Sub Text")
                /*.setStyle(new NotificationCompat.InboxStyle()
                        .addLine("This is line 1")
                        .addLine("This is line 2")
                        .addLine("This is line 3")
                        .addLine("This is line 4")
                        .addLine("This is line 5")
                        .addLine("This is line 6")
                        .addLine("This is line 7")
                        .setBigContentTitle("Big Content Title")
                        .setSummaryText("Summary Text"))*/
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManager.notify(2, notification);
    }
}