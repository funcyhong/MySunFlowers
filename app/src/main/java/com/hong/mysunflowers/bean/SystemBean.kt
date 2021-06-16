package com.hong.mysunflowers.bean

/**
 * Created by funcyhong
 * Date 2021/6/16 17:29
 * Description 体系 数据
 */
data class SystemBean(
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val visible: Int,
)