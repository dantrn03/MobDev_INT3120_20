package com.example.draft_unit14;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {
    int current_item;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String text = String.valueOf(item.getItemId());
        if (item.getItemId() == current_item) {
            text = "On selected item";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
            return super.onOptionsItemSelected(item);
        }
        Intent intent;
        if (item.getItemId() == R.id.item_web_view) {
            intent = new Intent(this, MainActivity.class);
        }
        else {
            intent = new Intent(this, WebServiceActivity.class);
        }
        this.startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
