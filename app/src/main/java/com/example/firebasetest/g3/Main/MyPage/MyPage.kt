package com.example.androidscaffolding.ui.Main.MyPage

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.ActivityMyPageBinding
import com.example.androidscaffolding.ui.Main.MainActivity
import com.example.androidscaffolding.ui.Main.MyPage.adapter.Adapter
import com.example.androidscaffolding.ui.Main.MyPage.adapter.DbTestActivity

class MyPage : AppCompatActivity() {
    lateinit var binding : ActivityMyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 버튼 클릭 시 :  ?? 이동
        binding.textview9.setOnClickListener {
            val intent = Intent(this@MyPage,MainActivity::class.java)
            startActivity(intent)
        }



// 버튼 클릭 시 : 회원 정보 수정  호출,
        binding.textview5.setOnClickListener {
            // 갤러리 앱 호출, 인텐트의 액션 문자열을 사용함. 시스템꺼를 사용해서 정해진 문자열.
            // Intent.ACTION_PICK : 갤러리 호출
            // MediaStore.Images.Media.EXTERNAL_CONTENT_URI : 외부 저장소(갤러리)의 사진의 위치
            val intent = Intent(this@MyPage, DbTestActivity::class.java)
            startActivity(intent)
        }





//
//        }
//        // onCreate
//        fun AddData() {
//            buttonInsert!!.setOnClickListener {
//                val isInserted = myDB!!.insertData(
//                    editTextEmail!!.text.toString(),
//                    editTextPassword!!.text.toString(),
//                    filePath
//                )
//                if (isInserted == true)
//                    Toast.makeText(this@JoinActivity, "데이터추가 성공", Toast.LENGTH_LONG)
//                        .show()
//                else Toast.makeText(this@JoinActivity, "데이터추가 실패", Toast.LENGTH_LONG).show()
//            }
//        }
//
//

    }
}