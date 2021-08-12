package com.example.ktndsjiny_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

/*
* onCreate() - onStart() - onResume()
*
* */
class MainActivity : AppCompatActivity() {
    //자바 스타일의 싱글톤 패턴
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.helloWorldTextView).setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        startActivity(Intent(this,LoginActivity::class.java))
    }
    override fun onStart(){
        super.onStart()
        if(auth.currentUser == null){
            startActivity(Intent(this,LoginActivity::class.java))
        }else{
            //다른 Activity로 이동하는 경우 현재 액티비티 끝내기
            //finish()

        }
    }
}