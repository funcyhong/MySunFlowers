package com.hong.mysunflowers.diffs

import androidx.recyclerview.widget.DiffUtil
import com.hong.mysunflowers.bean.ArticlesResponse

/**
 * Created by funcyhong
 * Date 2021/6/16 17:45
 * Description 体系 --- 导航
 */
class SystemNavigationDiffCallBack : DiffUtil.ItemCallback<ArticlesResponse>(){
    override fun areItemsTheSame(oldItem: ArticlesResponse, newItem: ArticlesResponse): Boolean {
        return oldItem.cid == newItem.cid
    }

    override fun areContentsTheSame(oldItem: ArticlesResponse, newItem: ArticlesResponse): Boolean {
        return oldItem == newItem
    }
}