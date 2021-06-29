package com.hong.mysunflowers.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView

class TestTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : AppCompatTextView(context,attrs,defStyleAttr) {
    /**
     * Created by funcyhong
     * Date 2021/6/28 16:41
     * Description 测试 view事件分发
     */

    private val TAG : String = "TestTextView   "

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        println(TAG + "onTouchEvent")
        when(event?.action){
            MotionEvent.ACTION_DOWN -> println(TAG + "onTouchEvent MotionEvent.ACTION_DOWN")
            MotionEvent.ACTION_MOVE -> println(TAG + "onTouchEvent MotionEvent.ACTION_MOVE")
            MotionEvent.ACTION_UP -> println(TAG + "onTouchEvent MotionEvent.ACTION_UP")
            MotionEvent.ACTION_CANCEL -> println(TAG + "onTouchEvent MotionEvent.ACTION_CANCEL")
        }
        return true
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