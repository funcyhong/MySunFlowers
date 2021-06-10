package com.hong.mysunflowers.base

/**
 * 最原始的 json 格式数据
 */
class BaseResponse<T> {
    var errorCode = -1 // 错误码
    var errorMsg: String? = null // 错误信息
    var data: T? = null // 数据
    var dataState: DataState? = null // 当前请求的状态
    var error: Exception? = null // 主要是客户端发生的错误
}

enum class DataState {
    STATE_CREATE, // 创建
    STATE_LOADING, // 加载中
    STATE_SUCCESS, // 成功
    STATE_COMPLETED, // 完成
    STATE_EMPTY, // 数据为null
    STATE_FAILED, // 接口请求成功但是服务器返回error
    STATE_ERROR, // 请求失败
    STATE_UNKNOWN // 未知
}