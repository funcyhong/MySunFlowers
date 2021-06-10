package com.hong.mysunflowers.bean

/**
 * 问答 响应数据 data
 */
data class AnswersResponse(
    var curPage: Int,
    var datas: List<PageBean>,
    var offset: Int,
    var over: Boolean,
    var pageCount: Int,
    var size: Int,
    var total: Int,
)