package com.valleytech.databindingdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.valleytech.databindingdemo.databinding.ActivityBasicDataBindingBinding


class BasicBindingActivity : AppCompatActivity() {

    lateinit var userObj: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        userObj = User("Updating Value in OnCreate")
        val binding: ActivityBasicDataBindingBinding =
            DataBindingUtil.setContentView<ActivityBasicDataBindingBinding>(this, R.layout.activity_basic_data_binding).also {
                it.user = userObj
            }

        binding.btnClick.setOnClickListener {
            userObj = User("Changed Value on Click")
            binding.user = userObj
           // binding.executePendingBindings()
        }


    }
}
