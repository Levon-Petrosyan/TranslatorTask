package com.levonlight.translatortask.bindingadapters

import androidx.databinding.BindingAdapter
import com.levonlight.translatortask.view.CircleLoading

/**
 * Created by Levon Petrosyan on 7/8/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */

@BindingAdapter("showLoading")
fun CircleLoading.showLoading(show: Boolean?) {
    show?.let {
        if (it)
            showLoading()
        else
            hideLoading()
    }
}