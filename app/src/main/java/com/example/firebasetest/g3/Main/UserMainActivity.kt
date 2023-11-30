package com.example.androidscaffolding.ui.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebasetest.g3.R
import com.example.firebasetest.g3.databinding.ActivityUserMainBinding

class UserMainActivity : AppCompatActivity() {
    lateinit var binding : ActivityUserMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}