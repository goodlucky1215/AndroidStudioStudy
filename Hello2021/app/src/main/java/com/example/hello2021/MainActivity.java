package com.example.hello2021;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btn_send = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i=0;i<5;i++){

        }
        //setContentView(R.layout.activity_main);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        Button btn = new Button(this);
        btn.setText("첫번째");
        ll.addView(btn);
        Button btn2 = new Button(this);
        btn.setText("두번째");
        ll.addView(btn2);
        btn_send = findViewById(R.id.btn_send);
        setContentView(ll);
    }
}