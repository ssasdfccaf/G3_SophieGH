package com.example.firebasetest.g3.Auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.ActivityUserMainBinding
import com.example.firebasetest.g3.databinding.ActivityUserMainBinding

class UserMainActivity : AppCompatActivity() {
    lateinit var binding : ActivityUserMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}