package com.example.artexploration.part6;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.example.artexploration.R;

import static android.content.Context.NOTIFICATION_SERVICE;

public class Sample {

    public static void notifycation(Context context){

        Intent intent = new Intent(context,NotifyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notify_layout);
        remoteViews.setTextViewText(R.id.tv_notify, "remote");
        remoteViews.setOnClickPendingIntent(R.id.tv_notify,pendingIntent);


        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("我是通知的标题")
                .setContentText("我是一个通知")
                .setAutoCancel(true)
                .setCustomContentView(remoteViews)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        manager.notify(2,builder.build());




    }

}
