package com.example.workout2021_step1;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WokroutListFragment extends ListFragment {
    interface Listener {
        void itemClicked(long id); //추상클래스라 abstract 생략

    }
    private Listener listener = null;

    //두번째: 리스너 등록하기기
   public void onAttach(Context context){//붑모에 담긴 프래그먼트이므로 부모를 통해서 정보를 공유/접근 가능
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    //운동 제목에 클릭에 응답하기
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String names[] = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }
        // 배열 어댑터를 생성하여 배열 어댑터를 리스트뷰에 연결
        // Fragment는 context의 하위 클래스가 아니다.
        // this로 현재 컨텍스트를 배열 어댑터에 전달 할 수 없다.
        // LayoutInflater의 getContext()로 컨텍스트를 얻을 수 있다.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(inflater.getContext() //mainactivity가 된다고?
                        , android.R.layout.simple_list_item_1
                        , names);
        //배열 어뎁터를 리스트 뷰에 연결
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}