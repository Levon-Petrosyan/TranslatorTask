package com.levonlight.translatortask.search

import com.levonlight.translatortask.data.TranslateResponseItem

interface TranslationItemClick {
    fun onTranslationClick(item: TranslateResponseItem)
}