package com.example.watchfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int seconds = 0;
    private boolean running;
    //onStop메소드를 호출하기 전에 스탑워치가 실행중인지를 알 수 있도록
    //wasRunning이라는 새로운 변수가 필요
    //그래야 액티비티가 다시 보였을 때,
    //스톱워치의 상태를 실행 상태로 설정해야 할 지 알 수 있으니까
    //wasRunning이라는 새로운 변수에 opStop메소드가 호출된 순간 스톱워치가 실행중이었는지 저장함.
    boolean wasRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            //액티비티가 다시 생성되면 wasRunning변수의 상태를 복원
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        Button btn_start = findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = true;
            }
        });
        Button btn_stop = findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
            }
        });
        Button btn_reset = findViewById(R.id.btn_reset);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
                seconds = 0;
            }
        });
        runTimer();
    }
    //스통워치가 실행 중이었다면 스톱워치를 다시 실행하도록 onStart()를 구현해요
    @Override//라이프사이클 관리
    protected void onStart(){
        super.onStart();
        //적재소에 필요한 조건을 수렴할 때 변수 초기화 잘 하기
        if(wasRunning) {
            running = true;
        }

    }
    @Override //라이프사이클 관리
    protected void onStop(){
        super.onStop();
        //onstop메소드가 호출 되었을 때 스톱워치가 싫행 중이었는지 저장해요
        wasRunning = running;
        running = false;
    }

    //이전 상태를 저장하는 코드
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt("seconds", seconds);
        saveInstanceState.putBoolean("running", running);

    }

    private void runTimer() {
        final TextView tv_time = findViewById(R.id.tv_time);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault()
                        , "%d:%02d:%02d", hours, minutes, secs);
                tv_time.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }//runTimer
}