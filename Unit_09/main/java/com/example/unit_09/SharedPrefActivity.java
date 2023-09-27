package com.example.unit_09;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.draft_unit09.R;

public class SharedPrefActivity extends AppCompatActivity {
    Util util;
    EditText edit;
    TextView load;
    Button edit_button;
    Button load_button;
    Button delete;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        util = new Util(this, R.id.shared_pref_item);

        edit = (EditText) findViewById(R.id.shared_pref_save);
        load = (TextView) findViewById(R.id.shared_pref_load);
        edit_button = (Button) findViewById(R.id.shared_pref_save_button);
        load_button = (Button) findViewById(R.id.shared_pref_load_button);
        delete = (Button) findViewById(R.id.shared_pref_delete);

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        util.handle_menu_item_selected(item);
        return super.onOptionsItemSelected(item);
    }

    public void save() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(TEXT, edit.getText().toString());
        editor.apply();
    }

    public void load() {
        load.setText(getSharedPreferences(SHARED_PREFS, MODE_PRIVATE).getString(TEXT, "Text Preferences haven't been set yet"));
    }

    public void delete() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        sp.edit().remove(TEXT).commit();
    }
}