package com.example.firebasetest.g3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasetest.g3.databinding.AuthtaskRecyclerBinding

class TaskViewHolder(val binding : AuthtaskRecyclerBinding) : RecyclerView.ViewHolder(binding.root)
// LocalTodoFragmaent에 taskrecycler 어댑터
class recycleradapter(val datas: List<String>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =TaskViewHolder(
        AuthtaskRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false))



    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as TaskViewHolder).binding
        binding.headlineView.text=datas[position]
        binding.taskdescView.text=datas[position]

    }

}