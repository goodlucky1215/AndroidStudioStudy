package com.example.lotto80

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker

class MainActivity : AppCompatActivity() {
    //선언 뒤에 lazy가 오면 activity_main4.xml을 스캔할 때 까지 기다린다.
    //$(document).ready(function(){
    //      $("dg_dept").datagrid({
    //              url:"XXX.jsp"
    //      });
    //});
    private val runButton: Button by lazy {
        findViewById(R.id.runButton)
    }
    //NumberPicker의 범위를 정해주자. 지금은 0만 보임. 움직이지도 않음
    private val numberPicker: NumberPicker by lazy{
        findViewById(R.id.numberPicker)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberPicker.minValue = 1
        numberPicker.maxValue = 45

        //자동채번 버튼 구현
        initRunButton()
    }

    private fun initRunButton(){
        runButton.setOnClickListener{
            val list = getRandomNumber()
            Log.d("MainActivity", list.toString())
        }
    }

    override fun onStart(){
        super.onStart()
        //실행이 되어있다가 (백스텍에 머물러 있다가) 다시 소환될때 onCreate를 타는게 아니라 여기로 온다.
    }
    //채번 알고리즘
    private fun getRandomNumber():List<Int>{
        //자바의 apply => Integer name[] = new Integer[]{1,2,3,4,5}
        //자바라면 => List<Integer> num = new ArrayList<>();
        val numberList = mutableListOf<Int>()
            .apply {
                for (i in 1..45) {
                    this.add(i)
                }
            }
        numberList.shuffle() //1~45 숫자가 섞임
        val newList = numberList.subList(0,6) //배열0~6까지 자른단 얘기임
        return newList.sorted() //정렬시켜서 내보냄
    }
}