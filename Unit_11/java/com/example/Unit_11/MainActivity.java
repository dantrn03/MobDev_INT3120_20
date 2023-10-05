package com.example.Unit_11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.draft_unit11.R;

public class MainActivity extends AppCompatActivity {
    public static final String CHANNEL_ID = "exampleServiceChannel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_LOW);
        getSystemService(NotificationManager.class).createNotificationChannel(notificationChannel);
    }

    public void startForegroundService(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(new Intent(this, MyService.class));
        } else {
            Toast.makeText(this, "cannot start foreground", Toast.LENGTH_LONG).show();
        }
    }

    public void startService(View v) {
//        String input = editText.getText().toString();
//
//        Intent serviceIntent =  new Intent(this, MyService.class);
//        serviceIntent.putExtra("inputExtra", input);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            getApplicationContext().startForegroundService(serviceIntent);
//        }

        startService(new Intent(this, HelloService.class));
//        Toast.makeText(this, "Service started", Toast.LENGTH_LONG).show();
    }

    public void stopService(View v) {
        Intent serviceIntent = new Intent(this, HelloService.class);
        stopService(serviceIntent);
    }
}