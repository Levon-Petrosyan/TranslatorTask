package com.levonlight.translatortask.extensions

import android.content.Context
import android.widget.Toast

/**
 * Created by Levon Petrosyan on 7/8/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
