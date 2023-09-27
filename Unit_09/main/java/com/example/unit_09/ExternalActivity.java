package com.example.unit_09;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.draft_unit09.R;

import java.io.File;
import java.io.FileOutputStream;

public class ExternalActivity extends AppCompatActivity {
    private static final String FILE_NAME = "testingExternal.txt";
    Util util;
    EditText edit;
    TextView load;
    Button edit_button;
    Button load_button;
    TextView readable;
    TextView writable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        util = new Util(this, R.id.external_item);

        edit = (EditText) findViewById(R.id.external_save);
        load = (TextView) findViewById(R.id.external_load);
        edit_button = (Button) findViewById(R.id.external_save_button);
        load_button = (Button) findViewById(R.id.external_load_button);

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeFile(view);
            }
        });
        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                readFile(view);
            }
        });

        readable = (TextView) findViewById(R.id.external_readable);
        writable = (TextView) findViewById(R.id.external_writable);

        if (isExternalStorageWritable())
            writable.setText("True");
        if (isExternalStorageReadable())
            readable.setText("True");
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

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    public void writeFile(View v) {
        if (isExternalStorageWritable()) {
            File textFile = new File(Environment.getExternalStorageDirectory(), FILE_NAME);

            try {
                FileOutputStream fos = new FileOutputStream(textFile);
                fos.write(edit.getText().toString().getBytes());
                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}