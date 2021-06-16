package com.hong.mysunflowers.repositorys

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hong.mysunflowers.base.BaseLiveData
import com.hong.mysunflowers.base.BaseRepository
import com.hong.mysunflowers.bean.AnswersResponse
import com.hong.mysunflowers.bean.PageBean
import com.hong.mysunflowers.entitys.AnswersEntity
import com.hong.mysunflowers.https.ApiService
import com.hong.mysunflowers.repositorys.source.AnswersPagingSource
import kotlinx.coroutines.flow.Flow

/**
 * 问答
 */
class AnswersRepository(private val service: ApiService) : BaseRepository<AnswersResponse>() {

    companion object {
        private const val PAGE_SIZE = 10
        val config = PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = 5,
            initialLoadSize = 10,
            enablePlaceholders = false,
            maxSize = PAGE_SIZE * 3
        )
    }

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