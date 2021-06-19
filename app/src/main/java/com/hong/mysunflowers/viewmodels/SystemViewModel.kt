package com.hong.mysunflowers.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hong.mysunflowers.base.BaseLiveData
import com.hong.mysunflowers.bean.SystemResponse
import com.hong.mysunflowers.repositorys.SystemRepository
import kotlinx.coroutines.launch

/**
 * Created by funcyhong
 * Date 2021/6/16 17:13
 * Description 体系 viewmodel
 */
class SystemViewModel(private val repository: SystemRepository) : ViewModel() {

    val systemBodyLiveData = BaseLiveData<List<SystemResponse>>()

    // 获取体系列表
    fun getBodyList(){
        viewModelScope.launch {
            repository.getBodyList(systemBodyLiveData)
        }
    }
}