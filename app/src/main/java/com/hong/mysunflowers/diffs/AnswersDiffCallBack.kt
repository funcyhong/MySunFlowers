package com.hong.mysunflowers.diffs

import androidx.recyclerview.widget.DiffUtil
import com.hong.mysunflowers.bean.PageBean

/**
 * 问答
 */
class AnswersDiffCallBack : DiffUtil.ItemCallback<PageBean>(){

    override fun areItemsTheSame(oldItem: PageBean, newItem: PageBean): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PageBean, newItem: PageBean): Boolean {
        return oldItem == newItem
    }
}