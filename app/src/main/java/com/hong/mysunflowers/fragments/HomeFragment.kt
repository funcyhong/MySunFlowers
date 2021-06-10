package com.hong.mysunflowers.fragments

import com.hong.mysunflowers.R
import com.hong.mysunflowers.base.BaseFragment

/**
 * 首页界面
 */
class HomeFragment : BaseFragment() {

    override fun init() {
        println("HomeFragment init()")
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }


}