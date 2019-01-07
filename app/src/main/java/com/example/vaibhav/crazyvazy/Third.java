package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Third extends AppCompatActivity {
    Button music,camera,calc,sms,back,special,aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        music=(Button)findViewById(R.id.music);
        camera=(Button)findViewById(R.id.camera);
        calc=(Button)findViewById(R.id.calc);
        sms=(Button)findViewById(R.id.sms);
        special=(Button)findViewById(R.id.special);
        aa=(Button)findViewById(R.id.button19);
        back=(Button)findViewById(R.id.backthree);
        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u=new Intent(Third.this,eee.class);
                startActivity(u);
                finish();
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u=new Intent(Third.this,Media.class);
                startActivity(u);
                finish();
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(Third.this,Camera.class);
                startActivity(n);
                finish();
            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l=new Intent(Third.this,Calculator.class);
                startActivity(l);
                finish();
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m=new Intent(Third.this,SMS.class);
                startActivity(m);
                finish();
            }
        });
        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(Third.this,Special.class);
                startActivity(k);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Third.this,MainActivity.class);
                startActivity(j);
                finish();
            }
        });

    }
}
