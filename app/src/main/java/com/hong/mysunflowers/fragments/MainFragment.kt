package com.hong.mysunflowers.fragments

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hong.mysunflowers.R
import com.hong.mysunflowers.adapters.*
import com.hong.mysunflowers.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * 主界面
 */
class MainFragment : BaseFragment() {

    override fun init() {
        initViewPager()
    }

    private fun initViewPager() {
        viewpager.adapter = HomePageAdapter(this)
        // 为每一个 tab 设置图标和文本
        TabLayoutMediator(
            tab,
            viewpager,
            fun(tab: TabLayout.Tab, position: Int) {
                tab.setIcon(getTabIcon(position))
                tab.text = getTabTitle(position)
            }
        ).attach()
    }

    private fun getTabTitle(position: Int): String {
        return when(position){
            HOME_PAGE_INDEX -> "首页"
            ANSWERS_PAGE_INDEX -> "问答"
            SYSTEM_PAGE_INDEX -> "体系"
            MINE_PAGE_INDEX -> "我的"
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            HOME_PAGE_INDEX -> R.drawable.selector_tab_home_icon
            ANSWERS_PAGE_INDEX -> R.drawable.selector_tab_answers_icon
            SYSTEM_PAGE_INDEX -> R.drawable.selector_tab_system_icon
            MINE_PAGE_INDEX -> R.drawable.selector_tab_mine_icon
            else -> throw IndexOutOfBoundsException()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }


}