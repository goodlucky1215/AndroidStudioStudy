package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ch4quiz2MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch4quiz2_main);

        Button change = (Button)findViewById(R.id.change);
        RadioButton sub = (RadioButton) findViewById(R.id.sub);
        RadioButton hwa = (RadioButton) findViewById(R.id.hwa);
        EditText temperature = (EditText) findViewById(R.id.temperature);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(temperature.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"숫자를 입력해주세요",Toast.LENGTH_SHORT).show();
                }
                else {
                    Float editNum = Float.parseFloat(temperature.getText().toString());
                    float result = 0;
                    if (sub.isChecked()) {
                        sub.setChecked(false);
                        hwa.setChecked(true);
                        result = hawchange(editNum);
                    } else if (hwa.isChecked()) {
                        sub.setChecked(true);
                        hwa.setChecked(false);
                        result = subchange(editNum);
                    }
                    temperature.setText(String.valueOf(result));
                }
            }
        });
    }

    private float subchange(Float editNum) {
        return (editNum-32)* 5 / 9;
    }

    private float hawchange(Float editNum) {
        return editNum*9/5+32;
    }
}