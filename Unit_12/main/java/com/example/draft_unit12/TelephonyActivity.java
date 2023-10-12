package com.example.draft_unit12;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;

public class TelephonyActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephony);
        super.current_item = R.id.item_tel;

        Button btn = findViewById(R.id.btn_dial);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dial = new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:555-2368"));
                startActivity(dial);
            }
        });
        Button btn_send1 = findViewById(R.id.btn_send1);
        Button btn_send2 = findViewById(R.id.btn_send2);

        btn_send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:55512345"));
                send.putExtra("sms_body", "Press send to send me");
                startActivity(send);
            }
        });
        btn_send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("5551234", null, "Android supports programmatic SMS messaging!", null, null);
            }
        });

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
    }
}