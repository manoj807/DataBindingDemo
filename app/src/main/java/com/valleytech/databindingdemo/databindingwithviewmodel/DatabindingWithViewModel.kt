package com.valleytech.databindingdemo.databindingwithviewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class DatabindingWithViewModel : ViewModel() {

     var name: ObservableField<String> = ObservableField("")
}