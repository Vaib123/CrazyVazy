package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Five extends AppCompatActivity {
    TextView t1;
    Button b1,b2,b3;
    RadioButton r1,r2,r3,r4,r5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        t1=(TextView)findViewById(R.id.textView6);
        b1=(Button)findViewById(R.id.button12);
        b2=(Button)findViewById(R.id.button13);
        b3=(Button)findViewById(R.id.button14);
        r1=(RadioButton)findViewById(R.id.radioButton21);
        r2=(RadioButton)findViewById(R.id.radioButton22);
        r3=(RadioButton)findViewById(R.id.radioButton23);
        r4=(RadioButton)findViewById(R.id.radioButton24);
        r5=(RadioButton)findViewById(R.id.radioButton25);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(r2.isChecked())
                {
                    One.score+=4;
                }
                else
                {
                    --One.score;
                }
                if(One.score==20)
                Toast.makeText(Five.this, "YOUR SCORE IS "+One.score+"  CONGRATULATIONS", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Five.this, "YOUR SCORE IS "+One.score+"  Can do better next time ", Toast.LENGTH_SHORT).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Five.this,One.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Five.this,Urll.class);
                startActivity(i);
                finish();

            }
        });
    }
}
