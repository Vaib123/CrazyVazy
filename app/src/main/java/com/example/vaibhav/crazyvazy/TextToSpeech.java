package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class TextToSpeech extends AppCompatActivity {
        Button b1,b2,b3,b4;
        EditText ed;
    android.speech.tts.TextToSpeech t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        b1=(Button)findViewById(R.id.texttospee);
        b2=(Button)findViewById(R.id.english);
        b3=(Button)findViewById(R.id.french);
        b4=(Button)findViewById(R.id.clearall);
        ed=(EditText)findViewById(R.id.editText13);

        t1=new android.speech.tts.TextToSpeech(this, new android.speech.tts.TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                t1.setLanguage(Locale.ENGLISH);
                t1.setSpeechRate(0.5f);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.speak(ed.getText().toString(), android.speech.tts.TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        t2=new android.speech.tts.TextToSpeech(this, new android.speech.tts.TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                t2.setLanguage(Locale.FRENCH);
                t2.setSpeechRate(0.5f);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.speak(ed.getText().toString(), android.speech.tts.TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TextToSpeech.this,Special.class);
                startActivity(i);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed.setText("");
            }
        });

    }
}
