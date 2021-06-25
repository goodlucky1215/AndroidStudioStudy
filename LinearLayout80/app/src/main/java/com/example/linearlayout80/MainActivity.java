package com.example.linearlayout80;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Button btn = null;
    //EditText et_name = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main.xml에서 그려진 버튼을 MainAcivity.java 에서 접근할 수 있다.
        //id를 선언하면 findViewById(R.id.xml에서 선언한 이름)
        //R.java는 안드로이드 스튜디오에서 자동으로 관리하는 클래스 로서
        //xml에서 그려진 화면 레이아웃 또는 버튼 같은 것들을 주소번지를 통해서 접근한다.
        //차이점은 아이디로 접근한다는 것이 다름
        //btn = findViewById(R.id.btn);
        //et_name = findViewById(R.id.et_name);
        //et_name.setText("테스트");
        //xml로 그려진 화면을 호출하는 것은 steContentView메소드의 파라미터로
        //xml문서의 이름을 사용하여 접근 호출함.
        setContentView(R.layout.activity_main);
    }
    public void send(View v){
        Toast toast = Toast.makeText(MainActivity.this,
                "전송호출",Toast.LENGTH_SHORT);
        toast.show();
    }
}