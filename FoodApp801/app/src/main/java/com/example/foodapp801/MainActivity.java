package com.example.foodapp801;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SectionPagerAdapter pagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    /*
    * 뷰페이저를 정의하면서 pager라는 ID를 할당합니다
    * 각 뷰 페이저는 액티비에서 참조할 수 있또록 반드시 ID를
    * 가져야합니다.
    * ID가 없으면 뷰페이지의 각 페이지에 어떤 프래그먼트를 표시할지
    * 지정할 수 없습니다.
    * 프래그먼트 페이저 어댑터를 사용하도록 페이저 설정하기
    * */

    private class SectionPagerAdapter extends FragmentPagerAdapter{

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }


        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new HomeFragment();
                case 1:
                    return new PizzaFragment();
                case 2:
                    return new PastaFragment();
                case 3:
                    return new StoreFragment();
            }
            return null;
        }

        public CharSequence getPagerTitle(int position) {
            switch (position) {
                case 0:
                    return "Home";
                case 1:
                    return "Pizza";
                case 2:
                    return "Pasta";
                case 3:
                    return "Store";
            }

            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }

    }

}