package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


public class MainActivity extends AppCompatActivity {

    private Button mNoti;
    private Button jumpToFirst;
    private Button jumpToSecond;
    private static Context mContext;
    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        mNoti = findViewById(R.id.notiMSG);
        jumpToFirst = findViewById(R.id.jumpToOne);
        jumpToSecond = findViewById(R.id.jumpToTwo);
        mNoti.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                sendNotification(mContext);
            }
        });
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelID = "chat";
            String channelName = "聊天消息";
            int important = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(channelID,channelName,important);
            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
        jumpToFirst.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startFirstActivity();
            }
        });
        jumpToSecond.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity();
            }
        });
        Log.d(TAG,"wangbin" + getTaskId());
    }

    void sendNotification(Context context){
        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,new Intent(context,MainActivity.class),0);
        Notification notify = new NotificationCompat.Builder(context,"chat")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setTicker("It's a new message").setContentTitle("Title")
                .setContentText("open the root window").setContentIntent(pendingIntent)
                .setNumber(1).build();
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        manager.notify(1,notify);
    }

    private void startFirstActivity(){
        Intent intent = new Intent(this,FirstActivity.class);
        startActivity(intent);
    }
    private void startSecondActivity(){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
