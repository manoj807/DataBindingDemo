package com.valleytech.databindingdemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.valleytech.databindingdemo.databinding.ActivityOneWayDataBindingBinding


class OneWayDataBindingActivity : AppCompatActivity() {
    val viewModel: OneWayDataBindingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityOneWayDataBindingBinding>(this, R.layout.activity_one_way_data_binding).also {
            it.viewModel=viewModel
        }

    }
}
