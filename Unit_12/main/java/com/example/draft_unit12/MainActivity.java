package com.example.draft_unit12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends MyActivity {

    private TextView barometer;
    private SensorManager mSensorManager;
    private Sensor pressureSensor;
    SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.current_item = R.id.item_sensor;
        barometer = findViewById(R.id.barometer_text);

//        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
//            Log.i("my Sensor", "Success");
//        }
//        else {
//            Log.i("my Sensor", "Fail");
//        }
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] values = sensorEvent.values;
                barometer.setText(String.format("%3f mbar", values[0]));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        pressureSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, pressureSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }
}