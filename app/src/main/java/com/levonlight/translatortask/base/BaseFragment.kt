package com.levonlight.translatortask.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<B : ViewDataBinding, V : BaseViewModel>(@LayoutRes layoutRes: Int) :
    Fragment(layoutRes) {

    lateinit var binding: B
        private set

    abstract val viewModel: V

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = super.onCreateView(inflater, container, savedInstanceState)

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = viewLifecycleOwner

        with(viewModel) {
            navById.observe(viewLifecycleOwner, Observer { observeNavById(it) })
        }
        setupView()
    }


    open fun setupView() {

    }

    open fun observeNavById(@IdRes resId: Int) {
        findNavController().navigate(resId)
    }
}