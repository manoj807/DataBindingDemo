package com.valleytech.databindingdemo.objectdatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.valleytech.databindingdemo.R
import com.valleytech.databindingdemo.databinding.ActivityObjectDatabinngBinding

class ObjectDatabindingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
       val activityBinding:ActivityObjectDatabinngBinding=DataBindingUtil.setContentView(this,R.layout.activity_object_databinng)
        activityBinding.employee=Employee("Manoj Kumar")
    }



}