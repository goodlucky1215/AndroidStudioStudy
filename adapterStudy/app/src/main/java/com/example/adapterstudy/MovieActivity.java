package com.example.adapterstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MovieActivity extends AppCompatActivity {
    ListView list;

    String[] titles = {
            "영화 1 (1923)",
            "영화 1 (1923)",
            "영화 1 (1923)",
            "영화 1 (1923)",
            "영화 1 (1923)",
            "영화 1 (1923)",
            "영화 1 (1923)",
            "영화 1 (1923)",
            "영화 1 (1923)"
    };

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
        setContentView(R.layout.activity_movie);
        CustomerList adapter = new CustomerList(MovieActivity.this); //메인액티비티를 넣어주고
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);//그 목록을 이 아이디 안에 담아준다.
    }

    public class CustomerList extends ArrayAdapter<String>{
        private final Activity context;
        public CustomerList(Activity context){
            super(context, R.layout.listitem, titles);
            this.context = context; //메인액티비이다.
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem, null,true);//영화목록담을 객체를 생성
            ImageView imgaeView = (ImageView) rowView.findViewById(R.id.image);//아이디들을 다 뽑아옴
            TextView title = (TextView) rowView.findViewById(R.id.title);
            TextView rating = (TextView) rowView.findViewById(R.id.rating);
            TextView genre = (TextView) rowView.findViewById(R.id.genre);
            TextView year = (TextView) rowView.findViewById(R.id.releaseYear);
            title.setText(titles[position]); //값을 전부 넣어서
            imgaeView.setImageResource(images[position]);
            rating.setText("9.0"+position);
            genre.setText("Action");
            year.setText(1930+position+"");
            return rowView;//그 뷰를 반환 시킨것이다.
        }
    }
}