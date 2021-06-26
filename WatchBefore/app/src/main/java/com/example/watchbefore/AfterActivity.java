package com.example.watchbefore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class AfterActivity extends AppCompatActivity {
    private int seconds = 0;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        Button btn_start = findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                running = true;
            }
        });
        Button btn_stop = findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                running = false;
            }
        });
        Button btn_reset = findViewById(R.id.btn_reset);
        btn_reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                running = false;
                seconds = 0;
            }
        });
        runTimer();
    }
    //이전 상태를 저장하는 코드
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt("seconds",seconds);
        saveInstanceState.putBoolean("running",running);

    }
    //public void start(View v){
    //    running// = true;
    //}
    //public void stop(View v){
    //    running = false;
    //}
    //public void reset(View v){
    //    running = false;
    //    seconds = 0;
    //}

    private void runTimer(){
        final TextView tv_time = findViewById(R.id.tv_time);
        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault()
                        , "%d:%02d:%02d",hours,minutes,secs);
                tv_time.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }//runTimer

/*
implements View.OnClickListener
    @Override
    public void onClick(View v) {
        Button btn = findViewById(R.id.btn_start);
        if(btn.equals(v.getId())){//누른 버튼과 해당 버튼의 이름이 같은 경우 이벤트 처리
            Log.i("",btn.getText().toString());
        }
    }*/
}

