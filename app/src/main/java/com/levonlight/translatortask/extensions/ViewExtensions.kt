package com.levonlight.translatortask.extensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Created by Levon Petrosyan on 7/8/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */

fun View.hideKeyboard() =
    (context.getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(
        windowToken,
        0
    )