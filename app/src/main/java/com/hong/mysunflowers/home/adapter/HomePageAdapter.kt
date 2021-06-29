package com.hong.mysunflowers.home.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hong.mysunflowers.bean.PageBean
import com.hong.mysunflowers.home.holder.HomePageViewHolder

/**
 * Created by funcyhong
 * Date 2021/6/22 15:11
 * Description 首页适配器
 */
class HomePageAdapter(diffCallback: DiffUtil.ItemCallback<PageBean>) :
    PagingDataAdapter<PageBean, HomePageViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        return HomePageViewHolder(parent)
    }
}