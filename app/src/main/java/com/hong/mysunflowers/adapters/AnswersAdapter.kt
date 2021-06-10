package com.hong.mysunflowers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hong.mysunflowers.R
import com.hong.mysunflowers.bean.PageBean
import com.hong.mysunflowers.holders.AnswersHolder

/**
 * 问答界面 --- 适配器
 */
class AnswersAdapter(differCallback: DiffUtil.ItemCallback<PageBean>) :
    ListAdapter<PageBean, AnswersHolder>(differCallback) {

    override fun onBindViewHolder(holder: AnswersHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswersHolder {
        return AnswersHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_answers, parent, false)
        )
    }
}