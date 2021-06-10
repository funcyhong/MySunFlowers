package com.hong.mysunflowers.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hong.mysunflowers.base.BaseLiveData
import com.hong.mysunflowers.bean.AnswersResponse
import com.hong.mysunflowers.entitys.AnswersEntity
import com.hong.mysunflowers.repositorys.AnswersRepository
import kotlinx.coroutines.launch

class AnswersViewModel(private val repository: AnswersRepository) : ViewModel() {

    val answersList = BaseLiveData<AnswersResponse>()

    fun getAnswersList(page: Int) {
        viewModelScope.launch {
            repository.getAnswersList(page, answersList)
        }
    }
}