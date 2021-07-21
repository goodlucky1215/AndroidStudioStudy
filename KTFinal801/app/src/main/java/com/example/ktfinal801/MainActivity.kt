package com.example.ktfinal801

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ktfinal801.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    //지연 초기화 - var로 선언된 프로퍼티만 가능, 프로퍼티에 대한 getter/setter 사용 불가
    private lateinit var binding: ActivityMainBinding
    //자바스럽게 이른 인스턴스화
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main) => 클릭 이벤트가 안 먹음.
        binding.helloworldTextView.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        if(auth.currentUser == null){
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, LikeActivity::class.java))
            finish()
        }
    }
}