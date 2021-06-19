package com.hong.mysunflowers.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.RelativeLayout
import androidx.viewpager2.widget.ViewPager2

/**
 * Created by funcyhong
 * Date 2021/6/19 14:22
 * Description 解决 view pager2 相互嵌套时同方向横向滑动冲突问题，源生的 view pager2 是被 final 修饰的，无法继承
 */
class ViewPagerContainer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) :
    RelativeLayout(context, attrs, defStyleAttr) {

    private var viewPager2: ViewPager2? = null
    private var downX: Float = 0f

    override fun onFinishInflate() {
        super.onFinishInflate()
        // 遍历找到 view pager2
        for (index in 0 until childCount) {
            if (getChildAt(index).also {
                    viewPager2 = it as ViewPager2
                } is ViewPager2) {
                break
            }
        }
        if (viewPager2 == null) {
            throw IllegalStateException("The root child of ViewPager2Container must contains a ViewPager2")
        }
    }

    override fun onInterceptTouchEvent(event: MotionEvent?): Boolean {
        // 如果view pager中是空的或者item个数少于2个，不予处理
        val doNotNeedIntercept = (!viewPager2!!.isUserInputEnabled
                || (viewPager2?.adapter != null
                && viewPager2?.adapter!!.itemCount <= 1))
        if (doNotNeedIntercept) {
            return super.onInterceptTouchEvent(event)
        }
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                val divideX = event.x - downX
                if (divideX > 0) {
                    // 右向滑动
                    if (viewPager2?.currentItem == 0){
                        // 此时在第一个 item , 那么不处理即可
                        parent.requestDisallowInterceptTouchEvent(false)
                    }else{
                        // 父控件不要拦截
                        parent.requestDisallowInterceptTouchEvent(true)
                    }
                } else {
                    // 左向滑动
                    if (viewPager2?.currentItem == viewPager2?.adapter?.itemCount!! - 1){
                        // 此时在最后 item , 那么不处理即可
                        parent.requestDisallowInterceptTouchEvent(false)
                    }else{
                        //
                        parent.requestDisallowInterceptTouchEvent(true)
                    }
                }
                downX = event.x
            }
        }
        return super.onInterceptTouchEvent(event)
    }
}