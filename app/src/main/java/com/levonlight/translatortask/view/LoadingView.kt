package com.levonlight.translatortask.view

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.levonlight.translatortask.R
import com.levonlight.translatortask.extensions.hideKeyboard
import kotlinx.android.synthetic.main.loading_view.view.*

/**
 * Created by Levon Petrosyan on 7/8/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */

class CircleLoading @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val autoStart: Boolean

    init {
        View.inflate(context, R.layout.loading_view, this).loaderContainer
        layoutTransition = LayoutTransition()
        context.obtainStyledAttributes(attrs, R.styleable.CircleLoading, defStyleAttr, 0)
            .apply {
                autoStart = getBoolean(R.styleable.CircleLoading_autostart, false)

            }.recycle()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        if (autoStart) {
            showLoading()
        } else {
            hideLoading()
        }
    }


     fun showLoading() {
        hideKeyboard()
        loaderContainer.visibility = View.VISIBLE
    }

     fun hideLoading() {
        hideKeyboard()
        loaderContainer.visibility = View.GONE
    }
}


