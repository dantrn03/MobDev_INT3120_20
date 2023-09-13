package com.example.test1309;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView ===========================================================================

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mobileArray);
//        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        // Spinner ===========================================================================

        Spinner spinner = (Spinner) findViewById(R.id.my_spinner);
        spinner.setAdapter(adapter);

        // GridView

        GridView gv = (GridView) findViewById(R.id.my_grid);
        gv.setAdapter(adapter);

        // AutoCompletTextView
        AutoCompleteTextView edit = (AutoCompleteTextView) findViewById(R.id.my_ACTV);
        edit.setAdapter(adapter);
    }
}