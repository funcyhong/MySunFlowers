package com.hong.mysunflowers.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hong.mysunflowers.bean.SystemResponse
import kotlinx.android.synthetic.main.item_answers.view.*

/**
 * Created by funcyhong
 * Date 2021/6/16 17:43
 * Description 体系 view holder
 */
class SystemBodyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(item: SystemResponse?) {
        item?.let {
            itemView.tv_answers_title.text = it.name
        }
    }
}