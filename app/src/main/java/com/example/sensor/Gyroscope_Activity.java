package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Gyroscope_Activity extends AppCompatActivity {

    private SensorManager sensorManager;
    private EditText etAdd, etSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope_);


        etAdd = findViewById(R.id.etAdd);
        etSub = findViewById(R.id.etSub);
    }

    private void sensorGyro()
    {
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SensorEventListener gyrolistner = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent)
            {
                if (sensorEvent.values[1] < 0)
                {
                    etAdd.setText("Left");

                }
                else if (sensorEvent.values[1] > 0)
                {
                    etSub.setText("Right");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i)
            {

            }
        };

        if (sensor != null)
        {
            sensorManager.registerListener(gyrolistner, sensor,SensorManager.SENSOR_DELAY_NORMAL);

        }
        else
        {
            Toast.makeText(this, " No sensor Found", Toast.LENGTH_SHORT).show();
        }
    }

}
