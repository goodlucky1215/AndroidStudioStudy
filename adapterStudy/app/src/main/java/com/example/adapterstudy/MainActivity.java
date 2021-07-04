package com.example.adapterstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] values = {"apple","apricot","avockat","banana","coconut","lemon"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        //new ArrayAdapter<String>(Context comtext=> 현재 어플리케이션 컨택스트, 레이아웃 아이디, 넣을 배열 값);
        setListAdapter(adapter); // 리스트 뷰에 어댑터 설정
    }

    @Override
    //사용자가 리스트 뷰의 항목을 클릭하게 되면 이 메소드가 호출된다.
    protected void onListItemClick(ListView l, View v, int position, long id){
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item+" selected", Toast.LENGTH_LONG).show();
    }
}