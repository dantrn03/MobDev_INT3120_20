package com.example.unit_09;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.draft_unit09.R;

public class Util {
    Context context;
    int current_item;
    Util (Context context, int current_id) {
        this.context = context;
        this.current_item = current_id;
    }
    public void handle_menu_item_selected(MenuItem item) {
        String text = String.valueOf(item.getItemId());
        if (item.getItemId() == current_item) {
            text = "On selected item";
            Toast.makeText(context, text, Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent;
        if (item.getItemId() == R.id.internal_item) {
            intent = new Intent(context, MainActivity.class);
        }
        else if (item.getItemId() == R.id.shared_pref_item) {
            intent = new Intent(context, SharedPrefActivity.class);
        }
        else if (item.getItemId() == R.id.external_item) {
            intent = new Intent(context, ExternalActivity.class);
        }
        else if (item.getItemId() == R.id.sqlite_item) {
            intent = new Intent(context, SQLiteActivity.class);
        }
        else if (item.getItemId() == R.id.file_system_item) {
            intent = new Intent(context, AndroidFileSystemActivity.class);
        }
        else {
            intent = new Intent(context, MainActivity.class);
        }
        context.startActivity(intent);
    }
}
