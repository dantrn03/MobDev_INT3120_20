package com.example.draft_unit12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.net.NetworkInterface;

public class WifiActivity extends MyActivity {

    private Switch wifiSwitch;
    private WifiManager wifiManager;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        super.current_item = R.id.item_wifi;

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifiManager.setWifiEnabled(true);
            }
        });
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null)
            Log.i("Network Info", String.valueOf(activeNetwork.getTypeName()));
//        NetworkInfo networkInfo = connectivityManager.get
//        WifiManager wifi = (WifiManager) getSystemService(WIFI_SERVICE);

        wifiSwitch = findViewById(R.id.wifi_switch);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);


        wifiSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // API 29, applications are not allowed to enable/disable Wifi
                wifiManager.setWifiEnabled(true);
                wifiSwitch.setText("WiFi is ON");
            } else {
                wifiManager.setWifiEnabled(false);
                wifiSwitch.setText("WiFi is OFF");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
    }

    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifiStateExtra) {
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiSwitch.setChecked(true);
                    wifiSwitch.setText("WiFi is ON");
                    Toast.makeText(getApplicationContext(), "WiFi ON", Toast.LENGTH_LONG).show();
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiSwitch.setChecked(false);
                    wifiSwitch.setText("WiFi is OFF");
                    Toast.makeText(getApplicationContext(), "WiFi OFF", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
}