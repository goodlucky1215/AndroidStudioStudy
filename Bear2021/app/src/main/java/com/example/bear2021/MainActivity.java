package com.example.bear2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  BeerExpert expert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //버튼을 클릭하면 호출됨.
    public void findBeer(View v){
        //텍스트뷰의 레퍼런스를 얻어온다.
        TextView brnds = findViewById(R.id.brands);
        //스피너의 레퍼런스를 얻어온다.
        Spinner color = findViewById(R.id.color);
        //스피너의 국가를 얻어온다.
        Spinner from = findViewById(R.id.from);
        //스피너에서 선택한 항목을 얻음.
        String beerType = String.valueOf(color.getSelectedItem());
        //스피너에서 선택한 항목을 얻음.
        String fromType = String.valueOf(from.getSelectedItem());
        //선택한 항목 표시하기
        List<String> brandsList = expert.getBrands(beerType,fromType);
        StringBuilder sb = new StringBuilder();
        for(String brand:brandsList){
            sb.append(brand).append("\n");
        }
        brnds.setText(sb.toString());
    }
}