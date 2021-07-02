package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void choice(View view){
        ImageView img = (ImageView) findViewById(R.id.img);
        boolean checked = ((RadioButton) view).isChecked(); //라디오 버튼 체크 여부
        switch (view.getId()){
            case R.id.one:
                if(checked) img.setImageResource(R.drawable.img1);
                break;
            case R.id.two:
                if(checked) img.setImageResource(R.drawable.img2);
                break;
            case R.id.three:
                if(checked) img.setImageResource(R.drawable.img);
                break;
        }
    }
}