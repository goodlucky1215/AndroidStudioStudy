package com.example.ktfcmpushnotice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    //이게 게으른 인스턴스화
    private val resultTextView: TextView by lazy{
        findViewById(R.id.resultTextView)
    }
    private val firebaseToken: TextView by lazy{
        findViewById(R.id.firebaseTokenText)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFirebase()
    }
    private fun initFirebase(){
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(){ task ->
                if(task.isSuccessful){
                    firebaseToken.text = task.result;
                }
            }
    }
}