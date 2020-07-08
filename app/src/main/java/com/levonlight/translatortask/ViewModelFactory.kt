package com.levonlight.translatortask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.levonlight.translatortask.search.SearchRepository
import com.levonlight.translatortask.search.SearchViewModel

/**
 * Created by Levon Petrosyan on 7/7/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */
@Suppress("UNCHECKED_CAST")
sealed class ViewModelFactory : ViewModelProvider.Factory {
    object SearchWord : ViewModelFactory()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(type)) {
            return viewModel as T
        }

        throw RuntimeException("No such ViewModel ---> ${modelClass.name}")
    }

    /**
     * type of expected [ViewModel]-s [Class]
     */
    private val type: Class<out ViewModel>
        get() = when (this) {
            SearchWord -> SearchViewModel::class.java
        }

    /**
     * expected [ViewModel] instance
     */
    private val viewModel: ViewModel
        get() = when (this) {
            is SearchWord -> SearchViewModel(SearchRepository())
        }
}

