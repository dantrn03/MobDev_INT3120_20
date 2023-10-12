package com.example.draft_unit13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GoogleMapActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        super.current_item = R.id.item_gmap;

    }
}