package com.levonlight.translatortask.bindingadapters

import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import com.levonlight.translatortask.data.TranslateResponseItem

/**
 * Created by Levon Petrosyan on 7/8/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */

@BindingAdapter("setTranslationText")
fun MaterialTextView.setTranslationText(translateResponseItem: TranslateResponseItem?) {
    text = translateResponseItem?.meanings?.get(0)?.translation?.text
}