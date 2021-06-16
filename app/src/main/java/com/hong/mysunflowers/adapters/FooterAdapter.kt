package com.hong.mysunflowers.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hong.mysunflowers.R
import kotlinx.android.synthetic.main.item_paging_footer.view.*


private const val TAG = "FooterAdapter"

/**
 *
 * @instruction：Paging 上拉尾部Adapter
 */
class FooterAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<FooterAdapter.FooterViewHolder>() {

    class FooterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(retry: () -> Unit, loadState: LoadState) {
            //加载失败时，点击重新请求
            view.bt_retry.setOnClickListener {
                retry()
            }
            run {
                view.progress_bar.isVisible = loadState is LoadState.Loading
                view.bt_retry.isVisible = loadState is LoadState.Error
            }
        }
    }

    override fun onBindViewHolder(holder: FooterViewHolder, loadState: LoadState) {
        Log.d(TAG, "onBindViewHolder: $loadState ")
        holder.bind(retry, loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): FooterViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_answers, parent, false)
        return FooterViewHolder(layout)

    }
}