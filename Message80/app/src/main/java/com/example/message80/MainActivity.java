package com.example.message80;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //savedInstanceState는 애플리케이션이 이전에 실행되었던 상태를 전달해준다.
        //그 안드로이드 생성 주기에서 맨 처음에 앱 실행할 때 한 번만 실행되는 부분이다.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //명시적 인텐트인듯 지정해서 클래스를 가져옴. .activity_main 이 화면을 가지고 온다는 것임.
    }
    public void send(View v){ //send(View v)가 실행되면 (activity_main에 onClick="send"가 있다
        //R.id.et_msg = Resource에 있는 id가 et_msg인 얘를 가져온다는 것임. => activiy_main.xml에 있다
        EditText et_msg = findViewById(R.id.et_msg);
        //그리고 거기안에 있는 텍스트를 가지고(getText()) 나와서 string() 타입으로 바꿔준다.
        String msg = et_msg.getText().toString();
        //Intent를 한다는 것은 다른 컴포넌트로 이동한다는 것임. this에서 ReceiveActivity.class로 가는 것이다
        //명시적 인텐트 인듯!
        Intent intent = new Intent(this, ReceiveActivity.class);
        //putExtra는 key,value로 "message"라는 이름으로 msg 값을 담는 다는 것임.
        intent.putExtra("message",msg);
        //정보를 담은 인텐트를 액티비티를 새 액티비티로 전달시켜준다는 것임. => onCreate로 간다~
        startActivity(intent);
    }
}