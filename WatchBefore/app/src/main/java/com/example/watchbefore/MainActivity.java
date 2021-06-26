package com.example.watchbefore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //스톱워치에 표시할 초
    private int seconds = 0;
    //스톱워치가 실행 중인가?
    //버튼에 대한 이벤트로 상태값이 바뀌고 사용은 다른 메소드에서 치리가 되니깐 이런 경우는 전역변수로 해야한다.
    //화면을 회전시키면 왜 액티비티를 다시 생성해야하지?
    //onCreate는 보통 화면을 설정하는 코드를 포함합니다.
    //onCreate메소드에서 수평, 수직모드와 관련된 특정 구성에 의존하고 있다.
    //bundle은 액티비티 상태를 저장하고 있으므로 안드로이드 os를 통해서 상태를 전달,관리할 수 있는 유용한 API이다.
    private boolean running;//false -> start버튼을 누르면 true로
    /* 지금까지의 흐른 시간과 현재 스톱워치가 실행 중인지 상태 저장*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //별동의 메소드를 이용해서 스톱워치를 갱신한다.
        //액티비티가 생성이되면 메소드를 시작합니다.
        runTimer();
    }
    public void start(View v){
        running = true;
    }
    public void stop(View v){
        running = false;
    }
    public void reset(View v){
        running = false;
        seconds = 0;
    }

    /*
    여기서는 레이아웃의 텍스트뷰 레퍼런스를 얻고 seconds변수의 값을 시, 분, 초
    형식으로 바꾼다음 텍스트뷰에 결과 표시
    만일 runing값이 true이면 seconds변수의 값을 1씩 증가시킬 것.
     */
    private void runTimer(){
        final TextView tv_time = findViewById(R.id.tv_time);
        //Handler사용하면 특정코드를 미래의 특정시점에 사용할 수 있음.
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
}




