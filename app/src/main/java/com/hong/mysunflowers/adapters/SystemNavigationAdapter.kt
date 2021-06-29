package com.hong.mysunflowers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.hong.mysunflowers.R
import com.hong.mysunflowers.bean.ArticlesResponse
import com.hong.mysunflowers.diffs.SystemNavigationDiffCallBack
import com.hong.mysunflowers.holders.SystemNavigationViewHolder

/**
 * Created by funcyhong
 * Date 2021/6/16 17:41
 * Description 体系 适配器
 */
class SystemNavigationAdapter : ListAdapter<ArticlesResponse, SystemNavigationViewHolder>(
    SystemNavigationDiffCallBack()) {

    override fun onBindViewHolder(holder: SystemNavigationViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SystemNavigationViewHolder {
        return SystemNavigationViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_body_system, parent, false))
    }

    override fun onViewRecycled(holder: SystemNavigationViewHolder) {
        super.onViewRecycled(holder)
        holder.recyclerTextView()
    }
}