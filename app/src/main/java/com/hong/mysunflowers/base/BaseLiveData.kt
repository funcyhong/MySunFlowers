package com.hong.mysunflowers.base

import androidx.lifecycle.MutableLiveData

/**
 * LiveData 基类
 */
class BaseLiveData<T> : MutableLiveData<BaseResponse<T>>() {
}