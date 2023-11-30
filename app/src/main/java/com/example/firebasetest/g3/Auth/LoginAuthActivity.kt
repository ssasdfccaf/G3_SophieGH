package com.example.firebasetest.g3.Auth

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.androidscaffolding.ui.Main.MyPage.Network.MyApplication
import com.example.firebasetest.g3.R
import com.example.firebasetest.g3.databinding.ActivityLoginAuthBinding
import com.example.firebasetest.g3.Project.BoardsFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider


class LoginAuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 구글 로그인 기능 확인.
        // 1) 구글 인증 버튼 눌러서 , 2) 후처리 함수를 호출 하기.
        // 1) 구글 인증 버튼, 구글의 파이어베이스 서버에 접속하고, 관련 인증을 가지고 돌아오기.
        // 2) 후처리 함수 만들기. 구글의 계정의 정보를 가지고와서, 처리하는 로직.
        val requestLauncher = registerForActivityResult(
            // 후처리 하는 함수가 정해져 있는데, 이함수를 인증 , 권한 확인용
            ActivityResultContracts.StartActivityForResult()
        ){
            // 실제 작업은 여기 이루어짐.
            // 구글 인증 결과 처리.
            // it.data 이부분이 구글로부터 받아온 계정 정보.
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            // 로그인 정보가 있는지? 없는지? 또는 네트워크 연결 오류등으로
            // 정보가 받거나 못 받거나 할 가능성이 있으면, 무조건, try catch 구문 사용함.
            try {
                // 계정 정보 가져오기.
                val account = task.getResult(ApiException::class.java)
                // 계정의 정보 가져오기.
                val credential = GoogleAuthProvider.getCredential(account.idToken,null)
                // 우리가 만든 MyApplication에서 auth로 확인
                MyApplication.auth.signInWithCredential(credential)
                    // 정보를 잘 가지고 왔을 때 , 수행이 될 콜백함수,
                    .addOnCompleteListener(this) {
                        // 수행할 작업.
                            task ->
                        if(task.isSuccessful){
                            MyApplication.email = account.email
                            Toast.makeText(this@LoginAuthActivity,"로그인 성공",Toast.LENGTH_SHORT).show()
                            Log.d("lsy","로그인 유저 : ${MyApplication.email }")
                            val pref = getSharedPreferences("loginInfo", MODE_PRIVATE)
                            val editor = pref.edit()
                            editor.putString("email", account.email)
                            editor.commit()
                            val boardsFragment = BoardsFragment()
                            supportFragmentManager.beginTransaction().replace(R.id.tabContent,boardsFragment).commit()
//                            finish()


//                            chageVisi("login")
                        } else {
//                            chageVisi("logout")
                        }
                    }
            } catch (e: ApiException){
//                chageVisi("logout")
            }
        }

        // 구글 로그인
        binding.googleAuthBtn.setOnClickListener {
            // 샘플 코드
            // 옵션, 이메일, 아이디토큰 가져오는 옵션
            val gso = GoogleSignInOptions
                // 오타, DEFAULT_SIGN_IN 인데 여기서 게임으로 잘못 잡혔음.
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(com.firebase.ui.auth.R.string.default_web_client_id))
                .requestEmail()
                .build()
            // 구글 인증 화면으로 이동하는 코드
            val signInIntent = GoogleSignIn.getClient(this,gso).signInIntent
            // 후처리 함수 동작 연결시키기.
            requestLauncher.launch(signInIntent)
        }

        //구글 로그아웃
        binding.googleLogoutBtn.setOnClickListener {
            MyApplication.auth.signOut()
            MyApplication.email = null
            val pref = getSharedPreferences("loginInfo", MODE_PRIVATE)
            val editor = pref.edit()
            editor.clear()
            editor.commit()
        }

    }
}