package com.hong.mysunflowers.fragments

import android.content.Intent
import com.hong.mysunflowers.R
import com.hong.mysunflowers.activitys.LikeActivity
import com.hong.mysunflowers.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 * 我的 界面
 */
class MineFragment : BaseFragment() {

    override fun init() {
        println("MineFragment init()")
        tv_open.setOnClickListener {
            startActivity(Intent(mContext, LikeActivity::class.java))
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }
}