package com.valleytech.databindingdemo.recycleview.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil


import com.valleytech.databindingdemo.R
import com.valleytech.databindingdemo.databinding.ActivityRecycleviewBinding

class RecycleViewDataBindingActivity : AppCompatActivity() {

    val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding = DataBindingUtil.setContentView<ActivityRecycleviewBinding>(this, R.layout.activity_recycleview)
        binding.recyclerView.adapter = MyAdapterClass(viewModel.dataList)
    }
}
