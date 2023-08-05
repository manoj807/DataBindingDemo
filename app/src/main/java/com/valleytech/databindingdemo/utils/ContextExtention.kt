package com.valleytech.databindingdemo.utils

import android.content.Context
import android.content.Intent


inline  fun <reified T:Any> Context.intent() =Intent(this, T::class.java)
