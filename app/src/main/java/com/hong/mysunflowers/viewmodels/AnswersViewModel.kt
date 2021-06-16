package com.hong.mysunflowers.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hong.mysunflowers.bean.PageBean
import com.hong.mysunflowers.entitys.AnswersEntity
import com.hong.mysunflowers.repositorys.AnswersRepository
import kotlinx.coroutines.flow.Flow

class AnswersViewModel(private val repository: AnswersRepository) : ViewModel() {

    fun getAnswersList(): Flow<PagingData<PageBean>> =
        repository.getAnswersList().cachedIn(viewModelScope)

}