package com.example.unit_08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.draft_unit08.R;


public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView textFeedback;
    Button buttonSendMessage;
    Button buttonToImplicit;
    final int MY_REQUEST_CODE = 1;
    MyBroadcastReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        registerReceiver(receiver, intentFilter);

//        Intent intent_broadcast = new Intent("ACTION_MY_EVENT");
//        intent_broadcast.putExtra("message", "Hello, this is a broadcast event!");
//        sendBroadcast(intent_broadcast);

        input = (EditText) findViewById(R.id.editTextText);
        textFeedback = (TextView) findViewById(R.id.textView3);
        this.buttonSendMessage = (Button) findViewById(R.id.button);
        this.buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        this.buttonToImplicit = (Button) findViewById(R.id.toImplicitButton);
        this.buttonToImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toImplicit();
            }
        });
    }

    public void sendMessage() {
        String fullName = this.input.getText().toString();
        String message = "Hello, Please say hello to me!";

        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("fullName", fullName);
        intent.putExtra("message", message);

        // Khoi dong Activity ma khong can feedback
//         this.startActivity(intent);

        // Khoi dong Activity va lay feedback
        this.startActivityForResult(intent, MY_REQUEST_CODE);
    }

    public void toImplicit() {
        Intent intent = new Intent(this, Implicit.class);
        Toast.makeText(this, receiver.getMessage(), Toast.LENGTH_LONG);

//        this.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == MY_REQUEST_CODE) {
            String feedback = data.getStringExtra("feedback");
            this.textFeedback.setText(feedback);
        }
        else {
            this.textFeedback.setText("!?");
        }
        String feedback = data.getStringExtra("feedback");
        this.textFeedback.setText(feedback);

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}