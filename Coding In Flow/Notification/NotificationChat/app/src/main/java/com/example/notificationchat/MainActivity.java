package com.example.notificationchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static com.example.notificationchat.App.CHANNEL_1_ID;
import static com.example.notificationchat.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    static List<Message> MESSAGE = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);

        MESSAGE.add(new Message("Good moring!", "Jim"));
        MESSAGE.add(new Message("Hello", null));
        MESSAGE.add(new Message("Hi!", "Jenny"));
    }

    public void sendOnChannel1(View view) {
        sendChannel1Notification(this);
    }

    public static void sendChannel1Notification(Context context) {


        Intent activityIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, activityIntent, 0);

        RemoteInput remoteInput = new RemoteInput.Builder("key_text_reply")
                .setLabel("Your answer...")
                .build();

        Intent replyIntent;
        PendingIntent replyPendingIntent = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            replyIntent = new Intent(context, DirectReplyReceiver.class);
            replyPendingIntent = PendingIntent.getBroadcast(context, 0, replyIntent, 0);
        } else {

        }

        NotificationCompat.Action replyAction = new NotificationCompat.Action.Builder(
                R.drawable.ic_previous,
                "Reply",
                replyPendingIntent
        ).addRemoteInput(remoteInput).build();

        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle("Me");
        messagingStyle.setConversationTitle("Group chat");

        for (Message chatMessage : MESSAGE) {
            NotificationCompat.MessagingStyle.Message notificationMessage =
                    new NotificationCompat.MessagingStyle.Message(
                            chatMessage.getText(),
                            chatMessage.getTimestamp(),
                            chatMessage.getSender()
                    );
            messagingStyle.addMessage(notificationMessage);
        }


        Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setStyle(messagingStyle)
                .addAction(replyAction)
                .setColor(Color.BLUE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
//                .addAction(R.mipmap.ic_launcher, "Toast", actionIntent)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(1, notification);
    }

    public void sendOnChannel2(View view) {
        final int progressMax = 100;

        final NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle("Download")
                .setContentText("Download in progress")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true) //Tiến trình đang diễn ra
                .setOnlyAlertOnce(true) //Thiết lập âm thanh cảnh báo 1 lần
                .setProgress(progressMax, 0, false);

        notificationManager.notify(2, notification.build());

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                for (int progress = 0; progress <= progressMax; progress += 10) {
                    notification.setProgress(progressMax, progress, false);
                    notificationManager.notify(2, notification.build());
                    SystemClock.sleep(1000);
                }
                notification.setContentText("Download finished")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                notificationManager.notify(2, notification.build());
            }
        }).start();
    }
}