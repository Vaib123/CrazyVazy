package com.example.vaibhav.crazyvazy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
        Button add,sub,mul,div,clear,back;
        EditText t1,t2;
        TextView e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.subtract);
        div=(Button)findViewById(R.id.div);
        mul=(Button)findViewById(R.id.mul);
        clear=(Button)findViewById(R.id.clear);
        back=(Button)findViewById(R.id.bickca);
        t1=(EditText)findViewById(R.id.editText9);
        t2=(EditText)findViewById(R.id.editText10);
        e1=(TextView)findViewById(R.id.textView);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    String s1=t1.getText().toString();
                    String s2=t2.getText().toString();
                    try {
                        double a = Double.parseDouble(s1);
                        double b = Double.parseDouble(s2);
                        double c = a + b;
                        e1.setText(String.valueOf(c));
                        Toast.makeText(Calculator.this, "ADDITION IS " + c, Toast.LENGTH_SHORT).show();
                    }catch (NumberFormatException e)
                    {

                    }
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                    String s1=t1.getText().toString();
                    String s2=t2.getText().toString();
                    try {
                        double a = Double.parseDouble(s1);
                        double b = Double.parseDouble(s2);
                        double c = a - b;
                        e1.setText(String.valueOf(c));
                        Toast.makeText(Calculator.this, "SUBTRACTION IS  " + c, Toast.LENGTH_SHORT).show();
                    }
                    catch (NumberFormatException e)
                    {

                    }
                }
            }
        });



        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    String s1=t1.getText().toString();
                    String s2=t2.getText().toString();
                    try {
                        double a = Double.parseDouble(s1);
                        double b = Double.parseDouble(s2);
                        double c = a * b;
                        e1.setText(String.valueOf(c));
                        Toast.makeText(Calculator.this, "MULTIPLICATION IS  " + c, Toast.LENGTH_SHORT).show();
                    }catch (NumberFormatException e)
                    {

                    }
                }
            }
        });

      div.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              {
                  String s1=t1.getText().toString();
                  String s2=t2.getText().toString();
                  try
                  {
                  double a=Double.parseDouble(s1);
                  double b=Double.parseDouble(s2);


                      double c = a / b;
                      e1.setText(String.valueOf(c));
                      Toast.makeText(Calculator.this, "DIVISION IS  "+c, Toast.LENGTH_SHORT).show();
                  }catch(NumberFormatException e)

                  {
                      Toast.makeText(Calculator.this, "DIVISION Is NOT POSSIBLE ", Toast.LENGTH_SHORT).show();}
              }
          }
      });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    t1.setText("");
                    t2.setText("");
                    e1.setText("");
                }
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent l=new Intent(Calculator.this,Third.class);
                    startActivity(l);
                    finish();
                }
            }
        });

    }
}
