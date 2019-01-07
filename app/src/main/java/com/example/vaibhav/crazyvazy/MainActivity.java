package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login,signup;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=t1.getText().toString();
                String s2=t2.getText().toString();
                if(s1.equals("")||  s2.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Fields can't be blank.Please fill both", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase data=openOrCreateDatabase("netcamp",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists employees (name varchar,email varchar,password varchar,city varchar,mobileno varchar)");
                    String s3="select * from employees where name='"+s1+"' and password='"+s2+"'";
                    Cursor cursor=data.rawQuery(s3,null);
                    if(cursor.getCount()>0)
                    {
                        Intent i=new Intent(MainActivity.this,Third.class);
                        startActivity(i);
                        finish();
                        Toast.makeText(MainActivity.this, "LOGIN SUCCESFUL", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "MISMATCH OF FIELDS", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
