package com.hong.mysunflowers.holders

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hong.mysunflowers.bean.SystemResponse
import com.hong.mysunflowers.widget.ColoredTextView
import com.hong.mysunflowers.widget.FlowLayout
import kotlinx.android.synthetic.main.item_body_system.view.*
import java.util.*


/**
 * Created by funcyhong
 * Date 2021/6/16 17:43
 * Description 体系 view holder
 */
class SystemBodyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // 主要是用来缓存 TextView
    private val mFlexItemTextViewCaches: Queue<ColoredTextView> = LinkedList()

    fun bindData(item: SystemResponse?) {
        item?.let {
            itemView.tv_title.text = it.name
            if (!item.children.isNullOrEmpty()) {
                itemView.fl.removeAllViews()
                for (index in item.children.indices) {
                    val coloredTextView = createOrGetTextView()
                    coloredTextView.text = item.children[index].name
                    val layoutParams = itemView.fl.layoutParams
                    layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
                    itemView.fl.addView(coloredTextView, layoutParams)
                }
            }
        }
    }

    private fun createTextView(): ColoredTextView =
        ColoredTextView(itemView.fl.context, null)

    private fun createOrGetTextView(): ColoredTextView =
        mFlexItemTextViewCaches.poll() ?: createTextView()

    fun recyclerTextView() {
        val flowLayout: FlowLayout = itemView.fl
        for (index in 0 until flowLayout.childCount) {
            this.mFlexItemTextViewCaches.offer(flowLayout.getChildAt(index) as ColoredTextView)
        }
        println(mFlexItemTextViewCaches.size)
        flowLayout.removeAllViews()
    }
}