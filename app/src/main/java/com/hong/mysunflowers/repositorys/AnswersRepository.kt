package com.hong.mysunflowers.repositorys

import androidx.paging.Pager
import androidx.paging.PagingData
import com.hong.mysunflowers.base.BaseRepository
import com.hong.mysunflowers.bean.AnswersResponse
import com.hong.mysunflowers.bean.PageBean
import com.hong.mysunflowers.config.PagerConfig.Companion.config
import com.hong.mysunflowers.https.ApiService
import com.hong.mysunflowers.pagingsources.AnswersPagingSource
import kotlinx.coroutines.flow.Flow

/**
 * 问答
 */
class AnswersRepository(private val service: ApiService) : BaseRepository<AnswersResponse>() {

//    suspend fun getAnswersList(page: Int, liveData: BaseLiveData<AnswersResponse>){
//        loadRepo({ service.getAnswersList(page) }, liveData)
//    }

    /**
     * 请求每日一问
     */
    fun getAnswersList(): Flow<PagingData<PageBean>> {
        return Pager(config) {
            AnswersPagingSource(service)
        }.flow
    }
}