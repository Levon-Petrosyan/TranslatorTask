package com.levonlight.translatortask

import androidx.lifecycle.MutableLiveData
import com.levonlight.translatortask.data.TranslateResponseItem

object SharedLiveData {

    val translatedItem: MutableLiveData<TranslateResponseItem> =
        MutableLiveData()

}