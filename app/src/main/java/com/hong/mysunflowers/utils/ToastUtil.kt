package com.hong.mysunflowers.utils

import android.widget.Toast
import com.hong.mysunflowers.app.HonsApplication

object ToastUtil {

    private var time: Long = 0
    private var oldMsg: String? = null

    fun show(msg: String) {
        if (msg != oldMsg) {
            create(msg)
            time = System.currentTimeMillis()
        } else {
            if (System.currentTimeMillis() - time > 2000) {
                create(msg)
                time = System.currentTimeMillis()
            }
        }
        oldMsg = msg
    }

    private fun create(massage: String) {
        val toast = Toast(HonsApplication.context)

        //设置显示时间
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }
}