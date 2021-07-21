package com.example.ktfinal801

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LikeActivity: AppCompatActivity() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var userDB: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like)

        userDB = Firebase.database.reference.child("Users")
        val currentUserDB = userDB.child(getCurrentUserID())
        currentUserDB.addListenerForSingleValueEvent(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.child("name".value == null)){
                    //널이면 팝업을 열어서 EditText에 이름을 받아온다.
                    showNameInputPopup()
                    return
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
            initSignOutButton()
        })
    }


    private fun getCurrentUserID(): String {
        //로그인이 풀리면 널일 수 있으니까 널에 대한 예외처리하기
        if(auth.currentUser == null){
            Toast.makeText(this, "로그인이 되어있지않습니다.", Toast.LENGTH_SHORT).show()
            //MainActivity로 돌아가도록  finish() 호출함.
            finish()
        }
        return auth.currentUser?.uid!!
    }

    //AlterDialog를 만들어서 이름값 받아오기
    private fun showNameInputPopup() {
        val editText = EditText(this)
        AlertDialog.Builder(this)
            .setTitle("이름을 입력해 주세요")
            .setView(editText)
            .setPositiveButton("저장") { _, _ ->//인자가 두개인 람다를 의미함
                if (editText.text.isEmpty()) {
                    //저장을 누르는 순간 팝업이 꺼지니까 다시 호출하면 된다.
                    showNameInputPopup()
                } else {
                    //다이얼로그에 입력한 이름을 받아서 파라미터로 넘김
                    saveUserName(editText.text.toString())
                }
            }
            .setCancelable(false)//취소를 못하도록 설정하기
            .show()
    }/////////////end of showNameInputPopup

    private fun saveUserName(name: String) {
        val userId = getCurrentUserID()
        val currentUserDB = userDB.child(userId)
        val user = mutableMapOf<String, Any>()
        user["userId"] = userId
        user["name"] = name
        //맵을 다시 만들어서 다시 저장하기
        currentUserDB.updateChildren(user)
        //여기에 유저 정보를 가져와라 함수 호출(DB연동하기로 추가부분)
        //한번도 선택하지 않은 유저정보를 가져와라.
        //getUnSelectedUsers()
    }

    //로그아웃 보기
    private fun initSignOutButton() {
        val signOutButton = findViewById<Button>(R.id.signOutButton)
        signOutButton.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            //그런데  finish를 하면 MainActivity로 돌아가서 onStart()를 호출
            //MainActivity에서 LikeActivity로 가는 else문 맨끝에 finish를 추가해줌.
            finish()
        }
    }

}