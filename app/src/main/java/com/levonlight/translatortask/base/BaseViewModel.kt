package com.levonlight.translatortask.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private val _navById: LiveData<Int> = MutableLiveData<Int>()
    val navById: LiveData<Int>
        get() = _navById


    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean>
        get() = _loading

    fun loading(show: Boolean) {
        _loading.postValue(show)
    }
}