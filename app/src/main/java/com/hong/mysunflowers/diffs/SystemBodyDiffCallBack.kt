package com.hong.mysunflowers.diffs

import androidx.recyclerview.widget.DiffUtil
import com.hong.mysunflowers.bean.SystemResponse

/**
 * Created by funcyhong
 * Date 2021/6/16 17:45
 * Description 体系
 */
class SystemBodyDiffCallBack : DiffUtil.ItemCallback<SystemResponse>(){
    override fun areItemsTheSame(oldItem: SystemResponse, newItem: SystemResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SystemResponse, newItem: SystemResponse): Boolean {
        return oldItem == newItem
    }
}