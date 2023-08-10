package com.valleytech.databindingdemo.livedatabinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataBindingViewModel:ViewModel()
{
    lateinit var name: MutableLiveData<String>
}