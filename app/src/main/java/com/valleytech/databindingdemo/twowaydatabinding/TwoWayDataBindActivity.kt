package com.valleytech.databindingdemo.twowaydatabinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.valleytech.databindingdemo.R
import com.valleytech.databindingdemo.databinding.ActivityTwoWayDataBindBinding

class TwoWayDataBindActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTwoWayDataBindBinding
    private var viewModel: TwoWayViewModel = TwoWayViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_data_bind)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}