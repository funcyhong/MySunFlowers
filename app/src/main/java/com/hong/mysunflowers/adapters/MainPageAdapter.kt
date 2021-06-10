package com.hong.mysunflowers.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hong.mysunflowers.fragments.AnswersFragment
import com.hong.mysunflowers.fragments.HomeFragment
import com.hong.mysunflowers.fragments.MineFragment
import com.hong.mysunflowers.fragments.SystemFragment

/**
 * 主界面 --- 适配器
 */
const val HOME_PAGE_INDEX = 0
const val ANSWERS_PAGE_INDEX = 1
const val SYSTEM_PAGE_INDEX = 2
const val MINE_PAGE_INDEX = 3

class HomePageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /**
     * ViewPager页面索引映射到它们各自的片段
     */
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        HOME_PAGE_INDEX to { HomeFragment() },
        ANSWERS_PAGE_INDEX to { AnswersFragment() },
        SYSTEM_PAGE_INDEX to { SystemFragment() },
        MINE_PAGE_INDEX to { MineFragment() })


    override fun getItemCount(): Int {
        return tabFragmentsCreators.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}