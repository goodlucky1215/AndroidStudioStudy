package com.example.workout801;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void itemClicked(long id) {
        //앱이 큰 화면을 가진 디바이스에서 실행될 때만 값이 존재해요.
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer!= null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            //트랜잭션에 기록하려는 여러 변경이 시작됨을 안드로이드에 알림.
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setWorkoutId(id);
            //프래그먼트를 바꾸려면 replace 메소드를 이용함.
            //프래그먼트를 제거하려면 ft.remove(fragment);
            ft.replace(R.id.fragment_container, details);
            //변경사항 저장하기
            //트랜잭션으로 그룹화할 모든 액션을 지정합니다. 프래그먼트 추가,교체,제거, 프래그먼트 데이터 갱신
            //백스택에 프래그먼트 추가 등이 여기에 해당
            //setTransition()메소드로 트랜잭션에 적용할 변환 애니메이션의 종류를 설정할 수 있다. 선택사항임.
            //새로운 프래그먼트와 예전 프래그먼트가 각각 희미해지고 또렷해지도록 설정함.
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            //트랜잭션을 백 스택에 추가합니다.
            //이 메소드는 트랜잭션의 레이블로 사용하는 문자열 이름을 한 개의 인자로 받습니다.
            ft.addToBackStack(null);
            //트랜잭션 커밋하기 - 모든 변경 사항을 적용함.
            ft.commit();
        }
        else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int)id);
            startActivity(intent);
        }
    }
}













