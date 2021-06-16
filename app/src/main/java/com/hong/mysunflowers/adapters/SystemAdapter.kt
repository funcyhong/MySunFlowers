package com.hong.mysunflowers.adapters

import androidx.fragment.app.Fragment
import com.hong.mysunflowers.base.BaseFragmentStateAdapter
import com.hong.mysunflowers.fragments.*

const val SYSTEM_BODY_PAGE_INDEX = 0
const val SYSTEM_NAVIGATION_PAGE_INDEX = 1

/**
 * Created by funcyhong
 * Date 2021/6/16 18:39
 * Description 体系 - 主界面 view pager 适配器
 */
class SystemAdapter(fragment: Fragment) : BaseFragmentStateAdapter(fragment) {

    override fun getTabFragmentsMapOf(): Map<Int, () -> Fragment> {
        return mapOf(
            SYSTEM_BODY_PAGE_INDEX to { SystemBodyFragment() },
            SYSTEM_NAVIGATION_PAGE_INDEX to { SystemNavigationFragment() },
        )
    }
}