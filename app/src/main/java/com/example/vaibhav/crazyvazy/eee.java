package com.example.vaibhav.crazyvazy;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class eee extends AppCompatActivity {
    TimePicker tp;
    AlarmManager am;
    PendingIntent pi;
    ToggleButton tbb;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eee);
        b2=(Button)findViewById(R.id.button18);
        tp=(TimePicker)findViewById(R.id.timePicker);
        tbb=(ToggleButton)findViewById(R.id.toggleButton);
        am=(AlarmManager)getSystemService(ALARM_SERVICE);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(eee.this,Third.class);
                startActivity(i);
                finish();
            }
        });
        tbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long time;
                if(tbb.isChecked())
                {
                    Toast.makeText(eee.this, "ALARM ON", Toast.LENGTH_SHORT).show();
                    Calendar c=Calendar.getInstance();
                    c.set(Calendar.HOUR_OF_DAY,tp.getHour());
                    c.set(Calendar.MINUTE,tp.getMinute());
                    Intent i=new Intent(eee.this,AlarmReceiver.class);
                    pi=PendingIntent.getBroadcast(eee.this,0,i,0);
                    time=(c.getTimeInMillis())-(c.getTimeInMillis()%60000);
                    if(System.currentTimeMillis()>time)
                    {
                        if(c.AM_PM==0)
                        {
                            time=time+(12*60*60*1000);
                        }
                        else
                            time=time+(24*60*60*1000);
                    }
                            am.setRepeating(AlarmManager.RTC_WAKEUP,time,10000,pi);

                }
                else
                {
                    am.cancel(pi);
                    Toast.makeText(eee.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
