package com.example.firebasetest.g3.Project

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidscaffolding.ui.Main.MyPage.Network.MyApplication
import com.example.firebasetest.g3.databinding.FragmentBoardsBinding


class BoardsFragment : Fragment() {
    private var mBinding : FragmentBoardsBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentBoardsBinding.inflate(inflater, container, false)
        mBinding = binding


        val button = binding.addListFAB
        button.setOnClickListener { view ->
            val bottomSheet = BBSFragment()
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
        }




        Log.d("lsy","로그인 유저 보드 프래그먼트  MyApplication.email : ${MyApplication.email}")

        val pref: SharedPreferences = requireActivity().getSharedPreferences("loginInfo", MODE_PRIVATE)
        val emailUser = pref.getString("email", "Default값")
        Log.d("lsy","로그인 유저 보드 프래그먼트 : ${emailUser}")
        Toast.makeText(context,"로그인 유저: ${emailUser}",Toast.LENGTH_SHORT).show()

        mBinding!!.loginUserView.text = emailUser

        return  mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}