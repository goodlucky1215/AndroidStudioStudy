package com.example.chunggo803

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.chunggo803.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity  : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    //네비게이션 바에 대한 이벤트 핸들러 감지 코드 추가 및 디폴트 프래그먼트 페이지 연결
    private fun initViews() = with(binding){
        bottomNavigationView.setOnNavigationItemSelectedListener(this@MainActivity)
        //최초 액티비티 화면 출력 시 기본 프래그먼트 페이지 붙임
        replaceFragment(HomeFragment.newInstance(), HomeFragment.TAG)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean{
        return  when (item.itemId) {
            R.id.home -> {
                replaceFragment(HomeFragment.newInstance(),HomeFragment.TAG)
                true
            }
            R.id.chatList ->{
                replaceFragment(ChatListFragment.newInstance(),ChatListFragment.TAG)
                true
            }
            R.id.myPage -> {
                replaceFragment(MyPageFragment.newInstance(),MyPageFragment.TAG)
                true
            }
            else -> false
        }
    }
    //하나의 액티비티 안에서 여러개의 프래그먼트 페이지들이 이동하고 유지되고 해야하니까
    //주의할 것.
    //특히 프래그먼트 내부에서의 이벤트 처리시 사용하고 이동시에는 확실히 remove처리할 것.
    private fun replaceFragment(fragment: Fragment, tag: String) {
        val findFragment = supportFragmentManager.findFragmentByTag(tag)
        //전처리 추가
        //프래그먼트가 교체가 될  때 나머지 프래그먼트는 hide로 만들어 주는 코드
        supportFragmentManager.fragments.forEach{ fm ->
            supportFragmentManager.beginTransaction().hide(fm).commitAllowingStateLoss()
        }
        //프래그먼트가 있으면
        findFragment?.let {
            supportFragmentManager.beginTransaction().show(it).commitAllowingStateLoss()
        } ?: kotlin.run {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer,fragment,tag)
                .commitAllowingStateLoss()
        }


    }
}