package com.hong.mysunflowers.holders

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hong.mysunflowers.bean.SystemResponse
import com.hong.mysunflowers.widget.ColoredTextView
import kotlinx.android.synthetic.main.item_body_system.view.*

/**
 * Created by funcyhong
 * Date 2021/6/16 17:43
 * Description 体系 view holder
 */
class SystemBodyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // 试图解决列表上下来回滑动回来时，流式布局的高度不是从0开始的，但是并没有卵用，已经在流式布局中处理
    private var needBindData = true

    fun bindData(item: SystemResponse?) {
        if (!needBindData) return
        item?.let {
            itemView.tv_title.text = it.name
            if (!item.children.isNullOrEmpty()) {
                for (index in item.children.indices) {
                    val coloredTextView = ColoredTextView(itemView.context, null)
                    coloredTextView.text = item.children[index].name
                    val layoutParams = itemView.fl.layoutParams
                    layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
                    itemView.fl.addView(coloredTextView,layoutParams)
                }
            }
            needBindData = true
        }
    }
}