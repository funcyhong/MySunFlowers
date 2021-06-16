package com.hong.mysunflowers.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hong.mysunflowers.bean.SystemResponse
import com.hong.mysunflowers.repositorys.SystemRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by funcyhong
 * Date 2021/6/16 17:13
 * Description 体系 viewmodel
 */
class SystemViewModel(private val repository: SystemRepository) : ViewModel() {

    fun getBodyList(): Flow<PagingData<SystemResponse>> {
        return repository.getBodyList().cachedIn(viewModelScope)
    }
}