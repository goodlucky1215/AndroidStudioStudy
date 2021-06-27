package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void plus(View v){
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        EditText result = (EditText) findViewById(R.id.result);
        Integer num3 = Integer.parseInt(num1.getText().toString()) +Integer.parseInt(num2.getText().toString());
        result.setText(num3.toString());

    }
    public void minus(View v){
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        EditText result = (EditText) findViewById(R.id.result);
        Integer num3 = Integer.parseInt(num1.getText().toString()) -Integer.parseInt(num2.getText().toString());
        result.setText(num3.toString());
    }
    public void multiply(View v){
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        EditText result = (EditText) findViewById(R.id.result);
        Integer num3 = Integer.parseInt(num1.getText().toString()) *Integer.parseInt(num2.getText().toString());
        result.setText(num3.toString());
    }
    public void division(View v){
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        EditText result = (EditText) findViewById(R.id.result);
        Integer num3 = Integer.parseInt(num1.getText().toString()) / Integer.parseInt(num2.getText().toString());
        result.setText(num3.toString());
    }
}