package com.levonlight.translatortask.search.details

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import coil.api.load
import com.levonlight.translatortask.R
import com.levonlight.translatortask.SharedLiveData
import com.levonlight.translatortask.base.BaseFragment
import com.levonlight.translatortask.databinding.FragmentDetailsBinding
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment :

    BaseFragment<FragmentDetailsBinding, DetailsViewModel>(R.layout.fragment_details) {

    override val viewModel: DetailsViewModel by viewModels()

    private val position = 0

    override fun setupView() {

        SharedLiveData.translatedItem.observe(viewLifecycleOwner, Observer {
            image.load(it.meanings[position].imageUrl) {
                binding.translateItem = it
                placeholder(R.drawable.ic_no_icon)
                error(R.drawable.ic_no_icon)
            }
        })
    }

    override fun onDestroy() {
        SharedLiveData.translatedItem.postValue(null)
        super.onDestroy()
    }
}