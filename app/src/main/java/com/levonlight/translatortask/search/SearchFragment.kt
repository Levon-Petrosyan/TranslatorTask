package com.levonlight.translatortask.search

import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.levonlight.translatortask.R
import com.levonlight.translatortask.SharedLiveData
import com.levonlight.translatortask.ViewModelFactory
import com.levonlight.translatortask.base.BaseFragment
import com.levonlight.translatortask.data.TranslateResponseItem
import com.levonlight.translatortask.databinding.FragmentSearchBinding
import com.levonlight.translatortask.extensions.toast
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewModel>(R.layout.fragment_search),
    TranslationItemClick {

    override val viewModel: SearchViewModel by viewModels { ViewModelFactory.SearchWord }

    private val adapter: TranslationListAdapter by lazy { TranslationListAdapter(this) }

    private val searchValidator: SearchValidator = SearchValidator()


    override fun setupView() {

        binding.viewModel = viewModel

        initRecycle()

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                if (searchValidator.isValidSearchText(query)) {
                    viewModel.searchItem(query)
                } else {
                    requireContext().toast("Please add correct word")
                }
                return false
            }

        })

        viewModel.translationListLiveData.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun initRecycle() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onTranslationClick(item: TranslateResponseItem) {
        SharedLiveData.translatedItem.postValue(item)
        observeNavById(R.id.action_searchFragment_to_detailsFragment)
    }
}