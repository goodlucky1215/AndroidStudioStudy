package com.example.mydraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private SingleTouchView drawView;
    private ImageButton currPaing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView = (SingleTouchView) findViewById(R.id.drawing);
        LinearLayout paintLayout = (LinearLayout) findViewById(R.id.paingColor); //색깔펜이 들어있는 리니얼레이아웃을 가지고 온다
        currPaing = (ImageButton) paintLayout.getChildAt(0); //그리고 그 리니얼레이아웃의 index 0번을 가져온다.
    }

    public void colorpan(View view){
        if(view!=currPaing){ //currPaing이 지금 view가 아니라면
            String color = view.getTag().toString(); //그 색깔펜의 색을 받아오고
            drawView.setColor(color); // 그 색을 셋팅해준다
            currPaing = (ImageButton) view; //그리고 currPaing에 그 화면을 보여준다
        }
    }
}