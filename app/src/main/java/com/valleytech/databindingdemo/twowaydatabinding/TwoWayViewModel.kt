package com.valleytech.databindingdemo.twowaydatabinding
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayViewModel : ViewModel() {

    //val userName = MutableLiveData<String>()

    var userName: ObservableField<String> = ObservableField("")

    //var userName:String=""

}