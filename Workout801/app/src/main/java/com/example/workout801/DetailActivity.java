package com.example.workout801;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
/*
Activity <- FragmentActivity <- AppCompatActivity <- YourActivity 상속관계임.
 */
public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment  frag = (WorkoutDetailFragment)getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        //id를 하드코딩 하지 않으므로 아래 행은 삭제하기
        //frag.setWorkoutId(1);
        //인텐트에서 아이디를 얻고 setWorkout()메소드로 프래그먼트에 전달함.
        int workoutId = (int)getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        //frag.setWorkoutId(workoutId);
        frag.setWorkoutId(workoutId);
    }
}





