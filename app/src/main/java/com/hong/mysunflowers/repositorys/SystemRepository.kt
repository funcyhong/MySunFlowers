package com.hong.mysunflowers.repositorys

import com.hong.mysunflowers.base.BaseLiveData
import com.hong.mysunflowers.base.BaseRepository
import com.hong.mysunflowers.bean.SystemResponse
import com.hong.mysunflowers.https.ApiService

/**
 * Created by funcyhong
 * Date 2021/6/16 17:15
 * Description 体系 repository
 */
class SystemRepository(private val service: ApiService) : BaseRepository<List<SystemResponse>>(){

    suspend fun getBodyList(liveData : BaseLiveData<List<SystemResponse>>){
        loadRepo({service.getBodySystemList()}, liveData)
    }

//    fun getBodyList() : Flow<PagingData<SystemResponse>>{
//        return Pager(PagerConfig.config){
//            SystemPagingSource(service)
//        }.flow
//    }
}