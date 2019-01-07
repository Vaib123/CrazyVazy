package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Media extends AppCompatActivity {
    Button play,pause,back;
    MediaPlayer mp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        back=(Button)findViewById(R.id.backmedia);
        play=(Button)findViewById(R.id.play);
        pause=(Button)findViewById(R.id.pause);
        pause.setEnabled(false);
        mp=MediaPlayer.create(this,R.raw.ph);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.release();
                Intent i=new Intent(Media.this,Third.class);
                startActivity(i);
                finish();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  pause.setEnabled(true);
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mp.pause();
            }
        });
    }
}
