package com.hong.mysunflowers.repositorys

import androidx.paging.Pager
import androidx.paging.PagingData
import com.hong.mysunflowers.base.BaseRepository
import com.hong.mysunflowers.bean.SystemResponse
import com.hong.mysunflowers.config.PagerConfig
import com.hong.mysunflowers.https.ApiService
import com.hong.mysunflowers.pagingsources.SystemPagingSource
import kotlinx.coroutines.flow.Flow

/**
 * Created by funcyhong
 * Date 2021/6/16 17:15
 * Description 体系 repository
 */
class SystemRepository(private val service: ApiService) : BaseRepository<SystemResponse>(){

    fun getBodyList() : Flow<PagingData<SystemResponse>>{
        return Pager(PagerConfig.config){
            SystemPagingSource(service)
        }.flow
    }
}