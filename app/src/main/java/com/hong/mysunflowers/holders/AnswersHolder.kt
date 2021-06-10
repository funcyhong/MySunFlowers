package com.hong.mysunflowers.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hong.mysunflowers.bean.PageBean
import kotlinx.android.synthetic.main.item_answers.view.*

class AnswersHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bindData(bean: PageBean?) {
        bean?.apply {
            view.tv_answers_title.text = title
        }
    }
}