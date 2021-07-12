package com.example.bmi80

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

/*
* new 예약어가 없다
* 힘수 뒤에 제네릭을 사용
* 객체 생성 후 초기화 할 때 apply() {} let()..... RecyclerView, XXXXAdapter, ViewHolder
* $XXXXXXXX변수 호출
* getIntent().getIntExtra
* getIntent().getStringExtra
* switch문 대신 when
* for문 경우 프로시저나 visual basic 문법이다
* */
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //xml, 리사이클러뷰 root, 레이아웃매니저
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)
        Log.d("resultActivity","height: $height,weight: $weight")

        val bmi = weight / (height / 100.0).pow(2.0)
        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }
        //insert here
        val resultValueTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}