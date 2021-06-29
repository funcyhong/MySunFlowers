package com.hong.mysunflowers.widget

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.RelativeLayout

/**
 * Created by funcyhong
 * Date 2021/6/28 16:32
 * Description 测试 view事件分发
 */

const val TAG : String = "TestRelativeLayout   "

class TestRelativeLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : RelativeLayout(context,attrs,defStyleAttr) {

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        println(TAG + "onTouchEvent")
        when(event?.action){
            MotionEvent.ACTION_DOWN -> println(TAG + "onTouchEvent MotionEvent.ACTION_DOWN")
            MotionEvent.ACTION_MOVE -> println(TAG + "onTouchEvent MotionEvent.ACTION_MOVE")
            MotionEvent.ACTION_UP -> println(TAG + "onTouchEvent MotionEvent.ACTION_UP")
            MotionEvent.ACTION_CANCEL -> println(TAG + "onTouchEvent MotionEvent.ACTION_CANCEL")
        }
        return super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        println(TAG + "onInterceptTouchEvent")
        when(ev?.action){
            MotionEvent.ACTION_DOWN -> println(TAG + "onInterceptTouchEvent MotionEvent.ACTION_DOWN")
            MotionEvent.ACTION_MOVE -> println(TAG + "onInterceptTouchEvent MotionEvent.ACTION_MOVE")
            MotionEvent.ACTION_UP -> println(TAG + "onInterceptTouchEvent MotionEvent.ACTION_UP")
            MotionEvent.ACTION_CANCEL -> println(TAG + "onInterceptTouchEvent MotionEvent.ACTION_CANCEL")
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        println(TAG + "dispatchKeyEvent")
        when(ev?.action){
            MotionEvent.ACTION_DOWN -> println(TAG + "dispatchKeyEvent MotionEvent.ACTION_DOWN")
            MotionEvent.ACTION_MOVE -> println(TAG + "dispatchKeyEvent MotionEvent.ACTION_MOVE")
            MotionEvent.ACTION_UP -> println(TAG + "dispatchKeyEvent MotionEvent.ACTION_UP")
            MotionEvent.ACTION_CANCEL -> println(TAG + "dispatchKeyEvent MotionEvent.ACTION_CANCEL")
        }
        return super.dispatchTouchEvent(ev)
    }
}