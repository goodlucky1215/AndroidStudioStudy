package com.example.message80;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SendActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        EditText et_msg = findViewById(R.id.et_msg);
        Intent intent = new Intent(Intent.ACTION_SEND);
        String msg = intent.getStringExtra("message");
    }
}
