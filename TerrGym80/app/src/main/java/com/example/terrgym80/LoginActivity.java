package com.example.terrgym80;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private  static final String TAG = "LoginActivity";
    private Map<String,String> pmap  = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginInit(View v){
        EditText etm_id = findViewById(R.id.etm_id);
        EditText etm_pw = findViewById(R.id.etm_pw);
        pmap.put("mem_id",etm_id.getText().toString());
        pmap.put("mem_pw",etm_pw.getText().toString());
        Log.i(TAG,"사용자가 입력한 값 ===>"+pmap);
        loginProcess(pmap);
    }

    public void loginProcess(Map<String,String> pmap){
        Log.i(TAG,"loginProcess ===>"+pmap);
        Toast.makeText(this,MemberDTO.getInstance().getMem_name()+"님 환영합니다",Toast.LENGTH_LONG).show();
    }
}