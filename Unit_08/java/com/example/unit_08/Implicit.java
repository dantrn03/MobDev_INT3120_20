package com.example.unit_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.draft_unit08.R;


public class Implicit extends AppCompatActivity {
    Button backButton;
    Button test_implicit;
    MyBroadcastReceiver receiver;
    TextView broadcast_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        test_implicit = (Button) findViewById(R.id.test_implicit);
        receiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("ACTION_MY_EVENT");
        registerReceiver(receiver, intentFilter);

        broadcast_msg = (TextView) findViewById(R.id.broadcast_msg);
        broadcast_msg.setText(receiver.getMessage());

        test_implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial();
            }
        });

        Button sendMessage = (Button) findViewById(R.id.button4);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send_msg();
            }
        });

        backButton = (Button) findViewById(R.id.backFromImplicit);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Implicit.this.onBackPressed();
            }
        });
    }

    public void dial() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 123"));
        startActivity(intent);
    }

    public void search() {
        Intent intent = new Intent (Intent.ACTION_WEB_SEARCH);
//        intent.putExtra(SearchManager.QUERY, "straight hitting golf clubs");
        startActivity(intent);
    }

    public void send_msg() {
        Intent intent = new Intent( Intent.ACTION_SENDTO, Uri.parse("sms:5551234"));
        intent.putExtra("sms body", "are we playing golf next Saturday?");
        startActivity(intent);
    }
}