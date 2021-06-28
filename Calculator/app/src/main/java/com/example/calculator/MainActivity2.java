package com.example.calculator;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calculator.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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