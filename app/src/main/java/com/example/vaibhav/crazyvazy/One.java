package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class One extends AppCompatActivity {
    TextView t1;
    Button b1,b2;
    RadioButton r1,r2,r3,r4,r5;
    static int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        t1=(TextView)findViewById(R.id.textView2);
        b1=(Button)findViewById(R.id.button8);
        b2=(Button)findViewById(R.id.button15);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);
        r5=(RadioButton)findViewById(R.id.radioButton5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=0;
                if(r4.isChecked())
                {
                    One.score+=4;
                }
                else
                {
                    --One.score;
                }
                Intent k=new Intent(One.this,Two.class);
                startActivity(k);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(One.this,Special.class);
                startActivity(i);
                finish();
            }
        });
    }
}
