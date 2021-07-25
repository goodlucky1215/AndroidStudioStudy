package com.example.ktitemfinalproject

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager

import android.net.Uri
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ktitemfinalproject.api.ItemService

import com.example.ktitemfinalproject.databinding.ActivityItemInsertBinding

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap



//아이템 등록하는 액티비티
class ItemInsertActivity : AppCompatActivity() {
    //이미지 등록 url
    private var selectedUri: Uri? = null
    //get,post url주소
    private lateinit var itemService : ItemService
    lateinit var imagepath : String
    //메인 UI
    private lateinit var iteminsertbinding: ActivityItemInsertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iteminsertbinding = ActivityItemInsertBinding.inflate(layoutInflater)
        setContentView(iteminsertbinding.root)

        //카테고리 스피너 담기
        val spinner: Spinner = iteminsertbinding.insertItemCategori
        ArrayAdapter.createFromResource(
            this,
            R.array.insertItemCategori,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


        //이미지 등록하기 버튼 클릭 시 권한확인
        findViewById<Button>(R.id.insertItemImgButton).setOnClickListener{
            when{
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    startContentProvider()
                }
                shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                    showPermissionContextPopup()
                }
                else ->{
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1010)
                }
            }
        }

        //retroifit으로 내가 연결해야할 서버에 접속
        //Gson으로 컨버터 해주는 부분
        val retrofit = Retrofit.Builder()
            .baseUrl(getString(R.string.ip_num))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //인터페이스인 itemService를 가져옴
        itemService = retrofit.create(ItemService::class.java)

        //상품을 올리는 버튼
        findViewById<Button>(R.id.insertItemButton).setOnClickListener {
            val title = findViewById<EditText>(R.id.insertItemTitle)
            val price = findViewById<EditText>(R.id.insertItemPrice)
            val spinner = findViewById<Spinner>(R.id.insertItemCategori)
            val categoriChoice = spinner.selectedItem.toString()
            val content = findViewById<EditText>(R.id.insertItemText)

            //값이 비워 있을 시
            if(title.text.isEmpty() || price.text.isEmpty() || categoriChoice.isEmpty() || content.text.isEmpty()){
                Toast.makeText(applicationContext,"모든 값을 채워주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(applicationContext,"사진 업로드 중입니다!!!!!!!!!",Toast.LENGTH_SHORT).show()
            imagepath = getRealPathFromURI(selectedUri).toString()
            val file = File(imagepath)
            // Uri 타입의 파일경로를 가지는 RequestBody 객체 생성
            val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"),file)
            val body = MultipartBody.Part.createFormData("file", file.getName(), requestFile)

            val title1 = RequestBody.create(MediaType.parse("text/plain"), title.text.toString());
            val price1 = RequestBody.create(MediaType.parse("text/plain"), price.text.toString());
            val categoriChoice1 = RequestBody.create(MediaType.parse("text/plain"), categoriChoice);
            val contents1 = RequestBody.create(MediaType.parse("text/plain"), content.text.toString());
            val nickName1 = RequestBody.create(MediaType.parse("text/plain"), "바나나");

            val requestMap = HashMap<String, RequestBody>();
            requestMap.put("pr_BM_TITLE", title1);
            requestMap.put("pr_BM_PRICE", price1);
            requestMap.put("pr_CATEGORY_NAME", categoriChoice1);
            requestMap.put("pr_BM_CONTENT", contents1);
            requestMap.put("pr_SELLER_NICKNAME", nickName1);
            //상품 등록하기
            itemInsert(requestMap,body)
            //중간에 이미지가 있으면 업로드 과정을 추가
            if(selectedUri != null){

            } else {
                Toast.makeText(applicationContext,"사진을 넣어주세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //finish를 하면 현재 화면이 아예 종료된다.
            finish()
        }


    }

    //사진 업로드
    private fun uploadPhoto(url: Uri, successHandler: (String) -> Unit, errorHandler:() -> Unit){
        val fileName = "${System.currentTimeMillis()}.png"

    }

    //상품 업로드하기
    private fun itemInsert(requestMap : HashMap<String, RequestBody>, imageUri: MultipartBody.Part){
        itemService.getItemInsertByName(requestMap,imageUri)
            .enqueue(object: Callback<ResponseBody>{
                //api 요청 성공시
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.isSuccessful.not()){
                        Log.e("main_fail","Not Success!!")
                        Toast.makeText(applicationContext,"사진 업로드 실패!!...",Toast.LENGTH_SHORT).show()
                        return
                    }
                    Toast.makeText(applicationContext,"상품이 등록되었습니다.",Toast.LENGTH_SHORT).show()
                }

                //api 요청 실패시
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.e("main_fail",t.toString())
                    Toast.makeText(applicationContext,"사진 업로드 실패2222!!...",Toast.LENGTH_SHORT).show()
                }

            })
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            1010 ->
                if(grantResults.isNotEmpty() && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                    startContentProvider()
                } else {
                    Toast.makeText(this, "권한을 거부하셨습니다.", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun startContentProvider() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent,2020)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode != Activity.RESULT_OK){
            return
        }

        when(requestCode){
            2020 ->{
                val uri = data?.data
                if (uri != null) {
                    findViewById<ImageView>(R.id.insertItemImg).setImageURI(uri)
                    selectedUri = uri
                }
            }
            else ->{
                Toast.makeText(this,"사진을 가져오지 못했습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getRealPathFromURI(contentUri: Uri?): String? {
        if (contentUri?.path?.startsWith("/storage") == true) {
            return contentUri.path.toString();
        }
        val id = DocumentsContract.getDocumentId(contentUri).split(":")[1]
        val columns = MediaStore.Files.FileColumns.DATA
        val selection = MediaStore.Files.FileColumns._ID + " = " + id;
        val cursor = getContentResolver().query(MediaStore.Files.getContentUri("external"),
            arrayOf(columns), selection, null, null)
        try {
            val columnIndex = cursor?.getColumnIndex(columns[0].toString())
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    return cursor.getString(0)
                }
            }
        } finally {
            cursor?.close();
        }
        return null
    }


    private fun showPermissionContextPopup(){
        AlertDialog.Builder(this)
            .setTitle("권한이 필요합니다.")
            .setMessage("사진을 가져오기 위해 필요합니다.")
            .setPositiveButton("동의"){_, _ ->
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1010)
            }
    }
}