package com.example.unit_09;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.draft_unit09.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";
    Util util;
    EditText internal_edit;
    TextView internal_load;
    Button internal_edit_button;
    Button internal_load_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.util = new Util(MainActivity.this, R.id.internal_item);
        internal_edit = (EditText) findViewById(R.id.internal_save);
        internal_load = (TextView) findViewById(R.id.internal_load);
        internal_edit_button = (Button) findViewById(R.id.internal_save_button);
        internal_load_button = (Button) findViewById(R.id.internal_load_button);

        internal_edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(view);
            }
        });

        internal_load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                write(view);
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

    public void save(View v) {
        String text = internal_edit.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(MainActivity.this, "Save to" + getFilesDir().getAbsolutePath() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             if (fos != null) {
//                 fos.close();
             }
        }
    }

    public void write(View v) {
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            internal_load.setText(sb.toString());
            Toast.makeText(MainActivity.this, "Read successfully?", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
//                fis.close();
            }
        }
    }

}