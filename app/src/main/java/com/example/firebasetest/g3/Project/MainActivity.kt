package com.example.firebasetest.g3.Project

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidscaffolding.ui.Auth.fragment.LocalTodoFragment
import com.example.firebasetest.g3.R
import com.example.firebasetest.g3.databinding.ActivityMainBinding
import com.example.firebasetest.g3.Project.BoardsFragment
import com.example.firebasetest.g3.Project.DashBoardFragment
import com.example.firebasetest.g3.Project.ProfileFragment
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    lateinit var localTodoFragment : Fragment
    lateinit var boardsFragment : Fragment
    lateinit var dashBoardFragment : Fragment
    lateinit var profileFragment : Fragment

    private var auth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)
        auth = Firebase.auth

        localTodoFragment = LocalTodoFragment()
        boardsFragment = BoardsFragment()
        dashBoardFragment = DashBoardFragment()
        profileFragment = ProfileFragment()

        val tabLayout = mainBinding.tabs
        supportFragmentManager.beginTransaction().add(R.id.tabContent,LocalTodoFragment()).commit()

        // 탭 이벤트 리스너 추가하기.
        tabLayout.addOnTabSelectedListener( object: TabLayout.OnTabSelectedListener {
            //익명 클래스 정의하고, 해당 이벤트 리스너 구현하면, 의무적으로,
            // 재정의 해야하는 함수3개 있음.
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when(tab?.text) {
                    "홈화면" -> transaction.replace(R.id.tabContent, LocalTodoFragment())
                    "보드목록" -> transaction.replace(R.id.tabContent, BoardsFragment())
                    "대시보드" -> transaction.replace(R.id.tabContent, DashBoardFragment())
                    "개인페이지" -> transaction.replace(R.id.tabContent, ProfileFragment())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"onTabUnselected",Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"onTabReselected",Toast.LENGTH_SHORT).show()
            }

        })


//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
//        // 네비게이션 컨트롤러
//        val navController = navHostFragment.navController
//
//        // 바텀 네비게이션 뷰 와 네비게이션을 묶어준다
//        NavigationUI.setupWithNavController(mainBinding.mainBottomNav, navController)



    }
}