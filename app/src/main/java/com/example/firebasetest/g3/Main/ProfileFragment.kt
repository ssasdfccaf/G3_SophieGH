package com.example.androidscaffolding.ui.Main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.FragmentDashBoardBinding
import com.example.androidscaffolding.databinding.FragmentProfileBinding
import com.example.androidscaffolding.ui.Main.MyPage.adapter.DbTestActivity

class ProfileFragment : Fragment() {

    private var mBinding: FragmentProfileBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        mBinding = binding

        // 버튼클릭시 :  ?? 이동
        binding.textview9.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        binding.textview5.setOnClickListener {
            // Activity 시작하기 위한 Intent
            val intent = Intent(requireContext(), DbTestActivity::class.java)
            startActivity(intent)
        }
        return  mBinding?.root

    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}