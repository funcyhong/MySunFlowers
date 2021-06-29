package com.hong.mysunflowers.widget

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children
import com.hong.mysunflowers.ktx.dp

/**
 * Created by funcyhong
 * Date 2021/6/19 16:00
 * Description 流式布局
 */
class FlowLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ViewGroup(context, attrs, defStyleAttr) {

    private val childrenBounds = mutableListOf<Rect>() // 保留了每一个view四个点位置信息
    private var useWidth = 0 // 对于每一行而言已经使用的宽度
    private var useHeight = 0f // 对于每一行已经使用的高度（用于展示子view显示高度）
    private var showHeight = 0f // 要展示的高度（本身的总高度）
    private var spacingX = 5.dp // item之间横向间距
    private var spacingY = 5.dp // item之间纵向间距

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val specWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        // 遍历每一个child
        for ((index, child) in children.withIndex()) {
            // 计算每一个child的宽高信息
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, useHeight.toInt())
            // 需要加上第一行本来的高度
            if (index == 0) showHeight += child.measuredHeight
            if (child.measuredWidth + spacingX + useWidth > specWidthSize) {   // 一行展示不下了
                // 计算使用的高度
                useHeight += spacingY + child.measuredHeight
                // 计算本身的高度
                showHeight += spacingY + child.measuredHeight
                // 初始化使用的宽度
                useWidth = 0
                // 重新计算
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, useHeight.toInt())
            }
            if (index >= childrenBounds.size) {
                childrenBounds.add(Rect())
            }
            val childBound = childrenBounds[index]
            // 设置每个child的坐标
            childBound.set(useWidth, useHeight.toInt(), useWidth + child.measuredWidth,
                (useHeight + child.measuredHeight).toInt())
            // 更新使用的宽度
            useWidth = (useWidth + child.measuredWidth + spacingX).toInt()
        }
        setMeasuredDimension(specWidthSize, showHeight.toInt())
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        // 依次布局就好，在测量的时候已经算好了位置
        for ((index, child) in children.withIndex()) {
            val childBounds = childrenBounds[index]
            child.layout(childBounds.left, childBounds.top, childBounds.right, childBounds.bottom)
        }
        //由于是在recyclerview中使用的，防止上下滑动回来时 useHeight 不断加大
        useHeight = 0f
        useWidth = 0
        showHeight = 0f
    }

    /**
     * 解决 android.view.ViewGroup$LayoutParams cannot be cast to android.view.ViewGroup$MarginLayoutParams
     */
    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}