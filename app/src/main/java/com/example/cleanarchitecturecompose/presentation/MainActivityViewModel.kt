package com.example.cleanarchitecturecompose.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel() : ViewModel() {

    private  val _status = MutableLiveData(false)
    val status:LiveData<Boolean> get() = _status


    private  val _test = MutableLiveData(0)
    val test:LiveData<Int> get() = _test



    fun returnState(email: String ,password:String ) {
        if (email.isEmpty()) {
            _status.postValue ( false)
            return

        }
        if (password.isEmpty()) {
            _status.postValue(false)
            return

        }
        _status.postValue (true)
    }

    fun check() {
          setData(1)
          setData(2)
          setData(3)
          setData(4)

    }

    private fun setData(num: Int) = CoroutineScope(Dispatchers.Main).launch {
        _test.postValue(num)

    }
}