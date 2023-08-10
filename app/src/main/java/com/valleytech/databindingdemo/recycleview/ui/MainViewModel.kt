package com.valleytech.databindingdemo.recycleview.ui

import androidx.lifecycle.ViewModel
import com.valleytech.databindingdemo.recycleview.model.DataClass

class MainViewModel : ViewModel() {

    var dataList: ArrayList<DataClass> = ArrayList()

    init {
        dataList.add(DataClass("1"))
        dataList.add(DataClass("2"))
        dataList.add(DataClass("3"))
        dataList.add(DataClass("4"))
        dataList.add(DataClass("5"))
    }
}