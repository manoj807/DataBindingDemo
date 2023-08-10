package com.valleytech.databindingdemo.observerfield

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField

import com.valleytech.databindingdemo.R

import com.valleytech.databindingdemo.databinding.ActivityObserverFieldBinding

class DatabindingWithObserverFieldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var userObj:User = User(ObservableField("changed in on Create"))
        val binding: ActivityObserverFieldBinding = DataBindingUtil.setContentView<ActivityObserverFieldBinding>(this,
            R.layout.activity_observer_field).also{
            it.user=userObj
        }

        binding.btnClick.setOnClickListener {
            binding.user!!.name.set("Changed value inside onclick")
        }
    }
}