package com.levonlight.translatortask

import androidx.lifecycle.MutableLiveData
import com.levonlight.translatortask.data.TranslateResponseItem

/**
 * Created by Levon Petrosyan on 7/8/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */
object SharedLiveData {

    val translatedItem: MutableLiveData<TranslateResponseItem> =
        MutableLiveData()

}