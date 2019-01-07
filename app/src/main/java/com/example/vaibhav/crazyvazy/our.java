package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class our extends AppCompatActivity {
    TextView t1;
    Button b1;
    RadioButton r1,r2,r3,r4,r5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our);
        t1=(TextView)findViewById(R.id.textView4);
        b1=(Button)findViewById(R.id.button10);
        r1=(RadioButton)findViewById(R.id.radioButton11);
        r2=(RadioButton)findViewById(R.id.radioButton12);
        r3=(RadioButton)findViewById(R.id.radioButton13);
        r4=(RadioButton)findViewById(R.id.radioButton14);
        r5=(RadioButton)findViewById(R.id.radioButton15);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(r5.isChecked())
                {
                    One.score+=4;
                }
                else
                {
                    --One.score;
                }
                Intent k=new Intent(our.this,Five.class);
                startActivity(k);
                finish();
            }
        });
    }
}
