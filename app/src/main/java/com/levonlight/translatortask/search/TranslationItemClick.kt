package com.levonlight.translatortask.search

import com.levonlight.translatortask.data.TranslateResponseItem

/**
 * Created by Levon Petrosyan on 7/8/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */
interface TranslationItemClick {
    fun onTranslationClick(item: TranslateResponseItem)
}