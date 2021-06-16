package com.hong.mysunflowers.base

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by funcyhong
 * Date 2021/6/16 18:43
 * Description view pager 适配器的基类
 */
abstract class BaseFragmentStateAdapter(
    fragment: Fragment,
) : FragmentStateAdapter(fragment) {

    abstract fun getTabFragmentsMapOf(): Map<Int, () -> Fragment>

    override fun getItemCount(): Int {
        return getTabFragmentsMapOf().size
    }

    override fun createFragment(position: Int): Fragment {
        return getTabFragmentsMapOf()[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}