package com.example.itemfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public class ItemAllActivity extends AppCompatActivity {
    ListView list;
    List<String> titles = new ArrayList<>();

    Integer[] images = {
            R.drawable.movie,
            R.drawable.movie,
            R.drawable.movie,
            R.drawable.movie,
            R.drawable.movie,
            R.drawable.movie,
            R.drawable.movie,
            R.drawable.movie,
            R.drawable.movie
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_all);
        ItemList adapter = new ItemList(ItemAllActivity.this); //메인액티비티를 넣어주고
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);//그 목록을 이 아이디 안에 담아준다.
    }

    //////////////////////////// [ [ 메뉴 영역 ]] ////////////////////////////////
    public class ItemList extends ArrayAdapter<String>{
        private final Activity context;
        public ItemList(Activity context) {
            super(context, R.layout.listitem, titles);
            this.context = context; //메인액티비이다.
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem, null,true);//영화목록담을 객체를 생성
            ImageView imgaeView = (ImageView) rowView.findViewById(R.id.bi_file);//아이디들을 다 뽑아옴
            TextView title = (TextView) rowView.findViewById(R.id.bm_title);
            TextView rating = (TextView) rowView.findViewById(R.id.bm_date);
            TextView genre = (TextView) rowView.findViewById(R.id.bm_price);
            title.setText(titles.get(position)); //값을 전부 넣어서
            imgaeView.setImageResource(images[position]);
            rating.setText("9.0"+position);
            genre.setText("Action");
            return rowView;
            //그 뷰를 반환 시킨것이다.
        }
    }









    //////////////////////////// [ [ 위에 옵션 메뉴 영역 ]] ////////////////////////////////
    //따로 작동시키지 않아도 알아서 작동된다.
    //옵션 메뉴를 생성(인기순으로 보여줄건지 아니면 최신순으로 보여줄 건지)
    //다음 메소드를 만들면, 매개변수에 menu객체가 전달된다. => 이 매개변수는 지금은 비어있는 메뉴다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //getMenuInflater()가 MenuInflater객체를 반환시킨다.
        // => 이 객체를 이용하여 inflate()를 호출하게 된다.
        MenuInflater inflater = getMenuInflater();
        //inflate()여기안에 내가 만든 메뉴layout(item_type.xml)을 넣으면,
        //inflate()가 item_type.xml를 팽창시켜서 menu객체로 만들어준다.
        //팽창이란? 프로그래밍 객체로 변환한다는 의미!
        //public void inflate(팽창 시킬 A아이, menu안에 저 A아이가 추가된다.)
        inflater.inflate(R.menu.item_type,menu);
        //false로하면 메뉴가 생성되지 않는다
        return true;
    }
    
    //옵션 메뉴에 대한 클릭 이벤트
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String pr_choice = null;
        switch (item.getItemId()){
            case R.id.like_rank:
                Toast.makeText(this,"인기순이야",Toast.LENGTH_SHORT).show();
                pr_choice = "like_rank";
                List<Map<String, Object>> itemList = null;
                String io =null;
                try{
                    ItemListLogic itemListLogic = new ItemListLogic();
                    io = itemListLogic.execute(pr_choice).get();
                    for(Map<String,Object> i : itemList){
                        titles.add(i.get("bm_title").toString());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                return true;
            case R.id.new_rank:
                pr_choice = "like_rank";
                Toast.makeText(this,"최신이 짱이야",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}