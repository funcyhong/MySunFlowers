package com.hong.mysunflowers.repositorys

import com.hong.mysunflowers.base.BaseLiveData
import com.hong.mysunflowers.base.BaseRepository
import com.hong.mysunflowers.bean.ArticlesResponse
import com.hong.mysunflowers.https.ApiService

/**
 * Created by funcyhong
 * Date 2021/6/16 17:15
 * Description 体系 --- 导航 repository
 */
class NavigationRepository(private val service: ApiService) : BaseRepository<List<ArticlesResponse>>(){

    suspend fun getNavigationList(liveData : BaseLiveData<List<ArticlesResponse>>){
        loadRepo({service.getNavigationSystemList()}, liveData)
    }

}