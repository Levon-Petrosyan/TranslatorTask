package com.levonlight.translatortask.bindingadapters

import androidx.databinding.BindingAdapter
import com.levonlight.translatortask.view.CircleLoading

@BindingAdapter("showLoading")
fun CircleLoading.showLoading(show: Boolean?) {
    show?.let {
        if (it)
            showLoading()
        else
            hideLoading()
    }
}