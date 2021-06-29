package com.hong.mysunflowers.home.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hong.mysunflowers.R
import com.hong.mysunflowers.bean.PageBean

/**
 * Created by funcyhong
 * Date 2021/6/22 15:13
 * Description 首页适配器 --- view holder
 */
class HomePageViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.item_home_page, parent, false)) {

    fun bind(item: PageBean?) {

    }

}