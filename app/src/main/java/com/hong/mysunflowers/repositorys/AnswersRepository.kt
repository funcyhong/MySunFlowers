package com.hong.mysunflowers.repositorys

import com.hong.mysunflowers.base.BaseLiveData
import com.hong.mysunflowers.base.BaseRepository
import com.hong.mysunflowers.bean.AnswersResponse
import com.hong.mysunflowers.entitys.AnswersEntity
import com.hong.mysunflowers.https.ApiService

/**
 * 问答
 */
class AnswersRepository(private val service: ApiService) : BaseRepository<AnswersResponse>() {

    suspend fun getAnswersList(page: Int, liveData: BaseLiveData<AnswersResponse>){
        loadRepo({ service.getAnswersList(page) }, liveData)
    }
}