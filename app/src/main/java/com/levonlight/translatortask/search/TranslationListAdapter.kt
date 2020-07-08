package com.levonlight.translatortask.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.levonlight.translatortask.data.TranslateResponseItem
import com.levonlight.translatortask.databinding.ItemTranslationListBinding

/**
 * Created by Levon Petrosyan on 7/8/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */
class TranslationListAdapter(private val translationItemClick: TranslationItemClick? = null) :
    ListAdapter<TranslateResponseItem, TranslationListAdapter.TranslationViewHolder>(
        TranslationDiffUtils()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TranslationViewHolder(
        ItemTranslationListBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        translationItemClick
    )

    override fun onBindViewHolder(holder: TranslationViewHolder, position: Int): Unit =
        getItem(position)?.let { holder.bind(it) }!!

    inner class TranslationViewHolder(
        binding: ItemTranslationListBinding,
        private val translationItemClick: TranslationItemClick?
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private val mBinding = binding

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            translationItemClick?.onTranslationClick(getItem(adapterPosition))
        }

        fun bind(item: TranslateResponseItem) = with(itemView) {
            mBinding.item = item
            mBinding.executePendingBindings()
        }
    }


    private class TranslationDiffUtils : DiffUtil.ItemCallback<TranslateResponseItem>() {
        override fun areItemsTheSame(
            oldItem: TranslateResponseItem,
            newItem: TranslateResponseItem
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TranslateResponseItem,
            newItem: TranslateResponseItem
        ): Boolean = oldItem == newItem
    }
}
