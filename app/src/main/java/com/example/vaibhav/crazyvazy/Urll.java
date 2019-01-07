package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Urll extends AppCompatActivity {
    Button b1;
    static int state=0;
    ImageButton b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urll);
        b1=(Button)findViewById(R.id.button16);
        b2=(ImageButton)findViewById(R.id.imageButton);
        b3=(ImageButton)findViewById(R.id.imageButton2);
        b4=(ImageButton)findViewById(R.id.imageButton3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent k=new Intent(Urll.this,Special.class);
                startActivity(k);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Urll.state=1;
                Intent k=new Intent(Urll.this,Last.class);
                startActivity(k);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Urll.state=2;
                Intent k=new Intent(Urll.this,Last.class);
                startActivity(k);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Urll.state=3;
                Intent k=new Intent(Urll.this,Last.class);
                startActivity(k);
                finish();
            }
        });
    }
}
