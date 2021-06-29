package com.hong.mysunflowers.fragments

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hong.mysunflowers.R
import com.hong.mysunflowers.adapters.SYSTEM_BODY_PAGE_INDEX
import com.hong.mysunflowers.adapters.SystemAdapter
import com.hong.mysunflowers.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_system.*

/**
 * 体系 主界面
 */
class SystemFragment : BaseFragment() {

    override fun init() {
        initViewPager()
    }

    private fun initViewPager() {
        viewpager.adapter = SystemAdapter(this)
        // 为每一个 tab 设置文字
        TabLayoutMediator(
            tab,
            viewpager,
            fun(tab: TabLayout.Tab, position: Int) {
                tab.text = getTabTitle(position)
            }
        ).attach()
    }

    private fun getTabTitle(position: Int): String {
        return when(position){
            SYSTEM_BODY_PAGE_INDEX -> "体系"
            else -> "导航"
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_system
    }

}