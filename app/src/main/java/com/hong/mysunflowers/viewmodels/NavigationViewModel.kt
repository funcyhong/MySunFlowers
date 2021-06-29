package com.hong.mysunflowers.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hong.mysunflowers.base.BaseLiveData
import com.hong.mysunflowers.bean.ArticlesResponse
import com.hong.mysunflowers.repositorys.NavigationRepository
import kotlinx.coroutines.launch

/**
 * Created by funcyhong
 * Date 2021/6/16 17:13
 * Description 体系 --- 导航 viewmodel
 */
class NavigationViewModel(private val repository: NavigationRepository) : ViewModel() {

    val systemNavigationLiveData = BaseLiveData<List<ArticlesResponse>>()

    // 获取导航列表
    fun getNavigationList(){
        
        viewModelScope.launch {
            repository.getNavigationList(systemNavigationLiveData)
        }
    }
}