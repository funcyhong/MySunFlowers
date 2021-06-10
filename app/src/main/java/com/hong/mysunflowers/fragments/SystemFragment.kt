package com.hong.mysunflowers.fragments

import com.hong.mysunflowers.R
import com.hong.mysunflowers.base.BaseFragment

/**
 * 体系 界面
 */
class SystemFragment : BaseFragment() {

    override fun init() {
        println("SystemFragment init()")
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_system
    }
}