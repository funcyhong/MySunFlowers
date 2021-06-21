package com.hong.mysunflowers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.hong.mysunflowers.R
import com.hong.mysunflowers.bean.SystemResponse
import com.hong.mysunflowers.diffs.SystemBodyDiffCallBack
import com.hong.mysunflowers.holders.SystemBodyViewHolder

/**
 * Created by funcyhong
 * Date 2021/6/16 17:41
 * Description 体系 适配器
 */
class SystemBodyAdapter : ListAdapter<SystemResponse, SystemBodyViewHolder>(
    SystemBodyDiffCallBack()) {

    override fun onBindViewHolder(holder: SystemBodyViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SystemBodyViewHolder {
        return SystemBodyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_body_system, parent, false))
    }

    override fun onViewRecycled(holder: SystemBodyViewHolder) {
        super.onViewRecycled(holder)
        holder.recyclerTextView()
    }
}