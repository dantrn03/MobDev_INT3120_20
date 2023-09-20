package com.example.draft_unit04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, TextWatcher {
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};
    TextView spinner_selection;
    TextView grid_selection;
    TextView auto_complete_text;
    AutoCompleteTextView edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView ===========================================================================

//        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mobileArray);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.name, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        // Spinner ===========================================================================

        spinner_selection = (TextView) findViewById(R.id.spinner_sel);
        Spinner spinner = (Spinner) findViewById(R.id.my_spinner);
        spinner.setOnItemSelectedListener(this);

        spinner.setAdapter(adapter);

        // GridView

        GridView gv = (GridView) findViewById(R.id.my_grid);
        gv.setAdapter(adapter);
        grid_selection = (TextView) findViewById(R.id.grid_sel);
        gv.setOnItemClickListener(this);

        // AutoCompleteTextView
        edit = (AutoCompleteTextView) findViewById(R.id.my_ACTV);
        edit.setAdapter(adapter);
        auto_complete_text = (TextView) findViewById(R.id.act_sel);


        createTabs();
    }

    private void createTabs() {
        TabHost tabs = (TabHost) findViewById(R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec;

        spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Uno");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Dos");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("tag3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tres");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("tag4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Cuatro");
        tabs.addTab(spec);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinner_selection.setText(mobileArray[i]);
        System.out.println("Something selected");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        System.out.println("Nothing sel");
        spinner_selection.setText("Nothing selected");
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        grid_selection.setText(mobileArray[i]);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        auto_complete_text.setText(edit.getText());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(MainActivity.this, "This is a message", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.item2) {
            Toast.makeText(MainActivity.this, "This is a message", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Donation.class);
            this.startActivity(intent);
        }
        if (id == R.id.item3) {
            Toast.makeText(MainActivity.this, "This is a message", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Order.class);
            this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}