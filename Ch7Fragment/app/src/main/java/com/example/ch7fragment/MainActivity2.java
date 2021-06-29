package com.example.ch7fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Fragment fragment = new FragmentB();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.content_frame, fragment); //프래그먼트를 담을 id를 가져온다.
        //commit 종류는 4가지 여기서 알맞은거 맞게 사용하기
        ft.commit(); //현재 화면에 상태 저장하고 처리
        //ft.commitNowAllowingStateLoss(); //상태 저장안하고 바로 실행
        //ft.commitNow(); //즉시 사용한다?
        //ft.commitNowAllowingStateLoss();
    }
}