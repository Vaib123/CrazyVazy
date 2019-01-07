package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class Last extends AppCompatActivity {
    Button b1;
    WebView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        b1=(Button)findViewById(R.id.button17);
        w=(WebView)findViewById(R.id.webView);
        WebSettings wb=w.getSettings();
        wb.setJavaScriptEnabled(true);
        wb.setJavaScriptCanOpenWindowsAutomatically(true);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent k=new Intent(Last.this,Urll.class);
                startActivity(k);
                finish();
            }
        });
        if(Urll.state==1)
            w.loadUrl("https://www.google.com");
        if(Urll.state==2)
            w.loadUrl("https://mobile.facebook.com");
        if(Urll.state==3)
            w.loadUrl("https://mobile.twitter.com");

    }
}
