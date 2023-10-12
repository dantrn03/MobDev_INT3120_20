package com.example.draft_unit12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.bluetooth.BluetoothAdapter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class BluetoothActivity extends MyActivity {
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        super.current_item = R.id.item_bluetooth;
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public void onClickBluetooth(View view) {
        if (bluetoothAdapter.isEnabled()) {
            Log.i("Bluetooth", "is Enabled");
//            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            }
//            bluetoothAdapter.startDiscovery();
        } else {
            Log.i("Bluetooth", "not Enabled");
        }
    }
}