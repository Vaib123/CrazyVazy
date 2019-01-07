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

public class RegisterActivity extends AppCompatActivity {
    Button back,register;
    EditText name,email,pas,city,phone,npas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        back=(Button)findViewById(R.id.backregister);
        register=(Button)findViewById(R.id.button);
        name=(EditText)findViewById(R.id.editText3);
        pas=(EditText)findViewById(R.id.editText4);
        npas=(EditText)findViewById(R.id.editText5);
        email=(EditText)findViewById(R.id.editText6);
        city=(EditText)findViewById(R.id.editText7);
        phone=(EditText)findViewById(R.id.editText8);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=name.getText().toString();
                String s4=pas.getText().toString();
                String s5=npas.getText().toString();
                String s6=email.getText().toString();
                String s7=city.getText().toString();
                String s8=phone.getText().toString();
                if(s.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals("")||s8.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else if(!s4.equals(s5))
                {
                    Toast.makeText(RegisterActivity.this, "Passwords did not match", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase data=openOrCreateDatabase("netcamp",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists employees (name varchar,email varchar,password varchar,city varchar,mobileno varchar)");
                    String s9="select * from employees where name='"+s+"' and email='"+s6+"'";
                    Cursor curse=data.rawQuery(s9,null);
                    if(curse.getCount()>0)
                    {

                        Toast.makeText(RegisterActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(RegisterActivity.this,MainActivity.class);
                        startActivity(j);
                        finish();

                    }
                    else
                    {
                        data.execSQL("insert into employees values('"+s+"','"+s6+"','"+s4+"','"+s7+"','"+s8+"')");
                        Toast.makeText(RegisterActivity.this, "Inserted into Database", Toast.LENGTH_SHORT).show();
                        Intent k=new Intent(RegisterActivity.this,MainActivity.class);
                        startActivity(k);
                        finish();
                    }
                }
            }
        });

    }
}
