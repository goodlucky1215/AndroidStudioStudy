package com.example.terrgym80;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoginFragment extends Fragment {
    //private TextView tv_msg2 = null;
    private TextView tv_msg = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(this.getClass().getName(),"onCreateView");
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        //tv_msg2 = view.findViewById(R.id.tv_msg); // 이렇게하면 접근이 불가능하다.
        //Log.i(this.getClass().getName(),tv_msg2.getText().toString());
        //onViewCreated는 의존성 주입을 주고 있기 때문에 onViewCreated()안에서 하면 접근이 가능하다.
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancesState){
        Log.i(this.getClass().getName(),"onCreateView");
        tv_msg = view.findViewById(R.id.tv_msg);
        Log.i(this.getClass().getName(),tv_msg.getText().toString());
    }
}