package com.example.unit_08;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.draft_unit08.R;


public class GreetingActivity extends AppCompatActivity {
    Button buttonBack;
    String fullName;
    String message;
    TextView textViewMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        buttonBack = (Button) findViewById(R.id.button2);
        textViewMessage = (TextView) findViewById(R.id.textView6);

        this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });

        Intent intent = this.getIntent();
        this.fullName = intent.getStringExtra("fullName");
        this.message = intent.getStringExtra("message");
        this.textViewMessage.setText(this.message);
    }

    public void goBack() {
        // Calling onBackPressed() method to back to the previous Activity.
        this.onBackPressed();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        String feedback = "OK, Hello " + this.fullName + ". How are you?";
        data.putExtra("feedback", feedback);

        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }
}