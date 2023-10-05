package com.example.unit_08;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    String message;

    MyBroadcastReceiver () {
        message = "Hell!";
//        message = "Hello, this is a broadcast event!";
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.message = intent.getStringExtra("message");
        Toast.makeText(context, message, Toast.LENGTH_LONG);
    }

    public String getMessage() {
        return message;
    }
}
