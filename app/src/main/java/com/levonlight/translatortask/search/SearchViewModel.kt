package com.levonlight.translatortask.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.levonlight.translatortask.base.BaseViewModel
import com.levonlight.translatortask.data.TranslateResponseItem
import com.levonlight.translatortask.extensions.fuelRequest

class SearchViewModel(private val repository: SearchRepository) : BaseViewModel() {

    private val _translationListLiveData: MutableLiveData<List<TranslateResponseItem>> =
        MutableLiveData()
    val translationListLiveData: LiveData<List<TranslateResponseItem>?>
        get() = _translationListLiveData

    fun searchItem(word: String) {
        loading(true)
        fuelRequest<List<TranslateResponseItem>>(repository.searchWord(word),
            { list ->
                _translationListLiveData.postValue(list)
                loading(false)
            }, {
                loading(false)
            })
    }
}