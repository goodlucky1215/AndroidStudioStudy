package com.example.ktbook802

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.ktbook802.adapter.BookAdapter
import com.example.ktbook802.adapter.HistoryAdapter
import com.example.ktbook802.api.BookService
import com.example.ktbook802.databinding.ActivityMainBinding
import com.example.ktbook802.model.BestSellerDTO
import com.example.ktbook802.model.History
import com.example.ktbook802.model.SearchBookDTO
import com.example.ktbook802.util.AppDatabase
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BookAdapter
    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var bookService: BookService
    //데이터 베이스 가져오기
    private lateinit var db: AppDatabase
    // : 는 extends를 의미. 클래스에 ()을 붙이는 것도 자바랑 다름!
    // fun은 function
    // ?가 있다면 null도 가능하다.
    // ?이 없다면 null-fafe(null이 불가능)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = BookAdapter()
        binding.bookRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.bookRecyclerView.adapter = adapter
        initHistoryRecyclerView()
        db = Room.databaseBuilder(applicationContext
            ,AppDatabase::class.java
            ,"BookSearchDB").build()

        //래트로핏 구현체 생성
        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        bookService = retrofit.create(BookService::class.java)
        ////////////////////[[ 베스트 셀러 목록 시작 ]]///////////////////
        bookService.getBestSellerBooks(getString(R.string.bookApiKey))
            .enqueue(object: Callback<BestSellerDTO> {
                override fun onResponse(
                    call: Call<BestSellerDTO>,
                    response: Response<BestSellerDTO>
                ) {
                    if(response.isSuccessful.not()){
                        Log.e(TAG, "NOT!!! SUCCESS")
                        return;
                    }
                    adapter.submitList(response.body()?.books.orEmpty())
                }

                override fun onFailure(call: Call<BestSellerDTO>, t: Throwable) {
                    //실패처리
                    Log.e(TAG, t.toString())
                }
            })
        ////////////////////[[ 베스트 셀러 목록  끝  ]]///////////////////
        initSearchEditText()
    }//////////////end of onCreate
    private fun initSearchEditText(){
        binding.searchEditText.setOnKeyListener{v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action == MotionEvent.ACTION_DOWN){
                search(binding.searchEditText.text.toString())
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
        binding.searchEditText.setOnTouchListener{v, event ->
            if(event.action == MotionEvent.ACTION_DOWN){
                showHistoryView()
            }
            return@setOnTouchListener false
        }
    }
    //검색기능 구현
    private fun search(keyword: String){
        bookService.getBooksByName(getString(R.string.bookApiKey),keyword)
            .enqueue(object: Callback<SearchBookDTO> {
                override fun onResponse(
                    call: Call<SearchBookDTO>,
                    response: Response<SearchBookDTO>
                ) {
                    hideHistoryView()
                    saveSearchKeyword(keyword)//;insertHistory
                    if(response.isSuccessful.not()){
                        Log.e(TAG, "NOT!!! SUCCESS")
                        return;
                    }
                    adapter.submitList(response.body()?.books.orEmpty())
                }

                override fun onFailure(call: Call<SearchBookDTO>, t: Throwable) {
                    //실패처리
                    hideHistoryView()
                    Log.e(TAG, t.toString())
                }
            })
    }
    private fun initHistoryRecyclerView(){
        historyAdapter = HistoryAdapter(historyDeleteClickedListener = {
            deleteSearchKeyword(it)
        })
        binding.historyRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.historyRecyclerView.adapter = historyAdapter
    }
    //삭제 후 뷰 갱신처리하기
    private fun showHistoryView(){
        Thread{
            val keywords = db.historyDao().getAll().reversed()
            //아래 코드가 없으면 저장은 되더라도 화면에 보이지 않아
            runOnUiThread{
                binding.historyRecyclerView.isVisible=true
                // 키워드에 널이 올 수 있으니까
                historyAdapter.submitList(keywords.orEmpty())
            }
        }.start()
    }
    //검색이 실패했을 때도 지워준다.
    private fun hideHistoryView(){
        binding.historyRecyclerView.isVisible = false
    }
    //검색된 키워드 등록처리
    private fun saveSearchKeyword(keyword: String){
        Thread{
            db.historyDao().insertHistory(History(null, keyword))
        }.start()
    }
    //검색 이력 삭제
    private fun deleteSearchKeyword(keyword: String){
        Thread{
            db.historyDao().delete(keyword)
            //삭제하고 나서 뷰 갱신처리하기
            showHistoryView()
        }.start()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}