package com.example.vaibhav.crazyvazy;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMS extends AppCompatActivity {
    Button back,sms;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        back=(Button)findViewById(R.id.backsms);
        sms=(Button)findViewById(R.id.sendd);
        t1=(EditText)findViewById(R.id.editText11);
        t2=(EditText)findViewById(R.id.editText12);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1="+91"+t1.getText().toString();
                String s2=t2.getText().toString();
                try
                {
                    Intent i=new Intent(getApplicationContext(),SMS.class);
                    PendingIntent p=PendingIntent.getActivity(getApplicationContext(),0,i,0);
                    SmsManager sm=SmsManager.getDefault();
                    sm.sendTextMessage(s1,null,s2,p,null);
                    Toast.makeText(SMS.this, "Message sent successfully", Toast.LENGTH_SHORT).show();
                }catch(Exception e)
                {
                    Toast.makeText(SMS.this, "Sms failed to send.Please try again", Toast.LENGTH_SHORT).show();
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SMS.this,Third.class);
                startActivity(i);
                finish();
            }
        });
    }
}
