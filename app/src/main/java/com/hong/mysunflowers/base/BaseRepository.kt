package com.hong.mysunflowers.base

/**
 * 子类 Repository 继承该类，网络请求时主要调用 loadRepo 方法
 */
open class BaseRepository<T> {

    /**
     * @param block ：返回值是 BaseResponse<T> 的挂起函数 ,挂起函数是具体的网络请求，T 是网络请求的返回转换数据
     * @param liveData ：观察 BaseResponse<T> 的 liveData
     */
    suspend fun loadRepo(
        block: suspend () -> BaseResponse<T>,
        liveData: BaseLiveData<T>,
    ) {
        var baseResponse = BaseResponse<T>()
        // 更新状态
        baseResponse.dataState = DataState.STATE_LOADING
        liveData.postValue(baseResponse)
        try {
            // 发起请求
            val invoke = block.invoke()
            // 请求结果赋值给 baseResponse
            baseResponse = invoke
            // 处理请求结果
            if (baseResponse.errorCode == 0) {
                // 请求成功
                if (baseResponse.data == null || baseResponse.data is List<*> && (baseResponse.data as List<*>).size == 0) {
                    // 没有数据
                    baseResponse.dataState = DataState.STATE_EMPTY
                }else{
                    baseResponse.dataState = DataState.STATE_SUCCESS
                }
            } else {
                // TODO 请求失败 STATE_FAILED这里的失败的状态还可以根据后台具体的细分
                baseResponse.dataState = DataState.STATE_FAILED
            }
        } catch (e: Exception) {
            // 异常
            baseResponse.dataState = DataState.STATE_ERROR
            baseResponse.error = e
        } finally {
            // 处理完请求通知对应的观察者更新 UI 等
            liveData.postValue(baseResponse)
        }
    }
}