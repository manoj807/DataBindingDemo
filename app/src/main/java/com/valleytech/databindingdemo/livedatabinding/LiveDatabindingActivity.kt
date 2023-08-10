package com.valleytech.databindingdemo.livedatabinding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData

import com.valleytech.databindingdemo.R
import com.valleytech.databindingdemo.databinding.ActivityLiveDataBindingBinding
import com.valleytech.databindingdemo.databinding.ActivityObjectDatabinngBinding

class LiveDatabindingActivity : AppCompatActivity() {

    val viewModel:LiveDataBindingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        viewModel.name = MutableLiveData()
        viewModel.name.value = "Value set inside OnCreate"

        val activityBinding:ActivityLiveDataBindingBinding=DataBindingUtil.setContentView<ActivityLiveDataBindingBinding?>(this,R.layout.activity_live_data_binding).also {
           it.viewModel=viewModel
           it.lifecycleOwner = this
       }


        activityBinding.btnClick.setOnClickListener {
            viewModel.name.value = "Value set on Button Click"
        }

    }



}