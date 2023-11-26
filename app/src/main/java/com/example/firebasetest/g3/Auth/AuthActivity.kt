package com.example.firebasetest.g3.Auth

//import androidx.navigation.fragment.NavHostFragment
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasetest.g3.databinding.ActivityAuthBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    // 전역으로 사용할 FirebaseAuth 생성
    private var auth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)

        // 전역 변수 설정
        auth = Firebase.auth

        // to 회원가입 창
        binding.signupOKBtn.setOnClickListener {
            createAccount(binding.signupEmailEt.text.toString(), binding.signupPasswordEt.text.toString())
        }

        // 로그인 버튼
        binding.loginBtn.setOnClickListener {
        }

        // 인플레이트
        setContentView(binding.root)

        // 호스트
 //       val navHostFragment = supportFragmentManager.findFragmentById(R.id.auth_nav_host) as NavHostFragment

        // 네비게이션 컨트롤러
  //      val navController = navHostFragment.navController


  //      OpeningDialogFragment().show(supportFragmentManager, "GAME_DIALOG")
    }


    // 계정 생성: 회원가입 함수 createAccount -> onCreate 에 할당
    private fun createAccount(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "계정 생성 완료",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish() // 가입창 종료
                    } else {
                        Toast.makeText(
                            this, "계정 생성 실패: ${task.exception?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}

