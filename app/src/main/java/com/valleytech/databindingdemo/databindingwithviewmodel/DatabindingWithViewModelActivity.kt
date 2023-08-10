package com.valleytech.databindingdemo.databindingwithviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil

import com.valleytech.databindingdemo.R
import com.valleytech.databindingdemo.databinding.ActivityDatabindingWithViewModelBinding


class DatabindingWithViewModelActivity : AppCompatActivity() {

    val viewModel by viewModels<DatabindingWithViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDatabindingWithViewModelBinding =
            DataBindingUtil.setContentView<ActivityDatabindingWithViewModelBinding>(this, R.layout.activity_databinding_with_view_model).also {
                viewModel.name.set("Value Changed in OnCreate")
                it.viewModel=viewModel
            }

        binding.btnClick.setOnClickListener {
            viewModel.name.set("Value Changed inside Onclick")
        }
    }
}
