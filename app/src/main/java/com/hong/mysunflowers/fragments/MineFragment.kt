package com.hong.mysunflowers.fragments

import com.hong.mysunflowers.R
import com.hong.mysunflowers.base.BaseFragment

/**
 * 我的 界面
 */
class MineFragment : BaseFragment() {

    override fun init() {
        println("MineFragment init()")
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }
}