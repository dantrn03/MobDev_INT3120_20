package com.example.draft_unit06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.button1 = (Button) findViewById(R.id.button_context);

        this.button2 = (Button) findViewById(R.id.check_me);
        this.button3 = (Button) findViewById(R.id.anchor);

        this.registerForContextMenu(button1);
    }

    private void button1Clicked() {
        PopupMenu popup = new PopupMenu(this, this.button2);
        popup.inflate(R.menu.layout_popup_menu);

        Menu menu = popup.getMenu();
//        Log.i(LOG_TAG, "Menu class: " + menu.getClass().getName());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

        popup.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.item1);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item2) {
            Toast.makeText(MainActivity.this, "item 2 clicked", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.item3) {
            Toast.makeText(MainActivity.this, "item 3 clicked", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.item4) {
            Toast.makeText(MainActivity.this, "item 4 clicked", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.item5) {
            Toast.makeText(MainActivity.this, "item 5 clicked", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.item6_1) {
            Toast.makeText(MainActivity.this, "item 6.1 clicked", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.item6_2) {
            Toast.makeText(MainActivity.this, "item 6.2 clicked", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context Menu Title");

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.context1) {
            Toast.makeText(MainActivity.this, "context 1 clicked", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.context2) {
            Toast.makeText(MainActivity.this, "context 2 clicked", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, this.button3);
        popup.inflate(R.menu.layout_popup_menu);
        popup.show();
    }
}