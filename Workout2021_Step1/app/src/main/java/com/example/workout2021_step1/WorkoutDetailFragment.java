package com.example.workout2021_step1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WorkoutDetailFragment extends Fragment {
    /*
    * 프래그먼트를 사용하는 액티비티가 있으면 액티비티는 어떤 방식으로든 프래그먼트와 의사소통을 해야함.
    * 예를 들어 레코드를 자세히 표시하는 프래그먼트가 있다면 액티비티가 어떤 레코드를 자세히 표시할지
    * 프래그먼트에 알려줘야 함.
    * 프래그먼트에 운동  ID값을 설정하는 단순한 setter메소드 추가
    * 그러면 액티비티는 이 메소드로 운동ID를 설정하게 됨.
    * 나중엔 운동 ID를 이용해 프래그먼트 뷰를 갱신함.
    * */
    private  long workoutId = 0; //운동 아이디를 담을 변수
    public void setWorkoutId(long workoutId){
        this.workoutId = workoutId;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    public  void onStart(){
        super.onStart();
        View view = getView(); //이걸로 부모에 접근할 수 있다?!
        if(view != null){
            TextView text_title = view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int)workoutId];
            text_title.setText(workout.getName());
            TextView description = view.findViewById(R.id.textDescription);
            description.setText((workout.getDescription()));
        }
    }
}