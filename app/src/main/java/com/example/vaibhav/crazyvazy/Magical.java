package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Magical extends AppCompatActivity implements SensorEventListener {
    Sensor s;
    SensorManager sm;
    MediaPlayer mp;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magical);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        mp=MediaPlayer.create(this,R.raw.dfff);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        back=(Button)findViewById(R.id.button6);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.unregisterListener(Magical.this,s);
                mp.release();
                Intent i=new Intent(Magical.this,Special.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]>5)
        {
            mp.start();
        }
        else
        {
            mp.pause();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
