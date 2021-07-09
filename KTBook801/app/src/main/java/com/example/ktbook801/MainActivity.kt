package com.example.ktbook801

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Constraints.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    // : 는 extends를 의미. 클래스에 ()을 붙이는 것도 자바랑 다름!
    // fun은 function
    // ?가 있다면 null도 가능하다.
    // ?이 없다면 null-fafe(null이 불가능)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //레트로핏 구현체 생성
        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val bookService = retrofit.create(BookService::class.java)

        bookService.getBestSellerBooks("인터파크도서키를 여기에 넣으면 된다")
            .enqueue(object: Callback<BestSellerDTO>{
                override fun onResponse(
                    call: Call<BestSellerDTO>,
                    response: Response<BestSellerDTO>
                ){
                    if(response.isSuccessful.not()){
                        Log.e(TAG, "Noo!!!!!!seuccess!!!!!!!!!")
                        return;
                    }
                    response.body()?.let{
                        Log.d(TAG, "body에서 꺼내오기"+it.toString())
                        it.books.forEach({ book ->
                            Log.d(TAG,book.toString())
                        })
                    }
                }

                //실패 처리를 선언해주지 않으면 에러가 생긴다
                override fun onFailure(call: Call<BestSellerDTO>, t: Throwable) {
                    //실패처리
                    Log.e(TAG, t.toString())
                }

            })
    }
}