package com.valleytech.databindingdemo.recycleview.ui

import android.util.Log

import com.valleytech.databindingdemo.R
import com.valleytech.databindingdemo.recycleview.basis.ClickCallback
import com.valleytech.databindingdemo.recycleview.basis.RecyclerBaseAdapterClass
import com.valleytech.databindingdemo.recycleview.model.DataClass

class MyAdapterClass(var data: List<DataClass>) : RecyclerBaseAdapterClass(), ClickCallback {

    override fun getLayoutIdForPosition(position: Int) = R.layout.row_data_item

    override fun getDataModel(position: Int) = data[position]

    override fun getItemCount() = data.size

    override fun getOnClickListener()= this

    override fun onClick( position: Int) {
        Log.e("Clicked Pos:", position.toString())
    }

}