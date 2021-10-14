package com.albert.homemodule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SinglePostViewModel : ViewModel(){

    private val _text = MutableLiveData<String>().apply {
        value = "Hello"
    }
    val text: LiveData<String> = _text

}