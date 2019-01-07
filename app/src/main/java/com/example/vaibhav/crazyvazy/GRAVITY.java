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
import android.widget.Toast;

public class GRAVITY extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor ss;
    Button back;
    MediaPlayer mp;
    long curtime,lastupdate;
    float x,y,z,last_x,last_y,last_z;
    final static long UpdatePeriod=100;
    final static int ShakeThreshold=200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);
        mp=MediaPlayer.create(this,R.raw.tumm);
        x=y=z=last_z=last_x=last_y=0.0f;
        curtime=lastupdate=0;
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        ss=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,ss,SensorManager.SENSOR_DELAY_NORMAL);
        back=(Button)findViewById(R.id.button3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.unregisterListener(GRAVITY.this,ss);
                mp.release();
                Intent i=new Intent(GRAVITY.this,Special.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
          long curtime=System.currentTimeMillis();
            if(curtime-lastupdate>UpdatePeriod)
            {
                long difftime=curtime-lastupdate;
                lastupdate=curtime;
                x=event.values[0];
                y=event.values[1];
                z=event.values[2];
                float speed=Math.abs(x+y+z-last_x-last_y-last_z)/difftime*10000;
                //Toast.makeText(GRAVITY.this, "Speed is "+speed, Toast.LENGTH_SHORT).show();
                if(speed>ShakeThreshold)
                    mp.start();
                else
                {
                    if(mp.isPlaying())
                    {
                        mp.pause();
                    }
                }
            }
            last_z=z;
            last_y=y;
            last_x=x;


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
