package com.levonlight.translatortask.bindingadapters

import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import com.levonlight.translatortask.data.TranslateResponseItem


@BindingAdapter("setTranslationText")
fun MaterialTextView.setTranslationText(translateResponseItem: TranslateResponseItem?) {
    text = translateResponseItem?.meanings?.get(0)?.translation?.text
}