package com.hong.mysunflowers.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hong.mysunflowers.bean.SystemResponse
import com.hong.mysunflowers.https.ApiService

/**
 * Created by funcyhong
 * Date 2021/6/16 17:34
 * Description 体系 - 获取数据源
 */
class SystemPagingSource(private val service: ApiService) : PagingSource<Int,SystemResponse>(){

    override fun getRefreshKey(state: PagingState<Int, SystemResponse>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SystemResponse> {
        return LoadResult.Error(Exception())
//        try {
//            val pageNum = params.key ?: 1
//            val data = service.getBodySystemList()
//            val preKey = if (pageNum > 1) pageNum - 1 else null
//            LoadResult.Page(data.data?.datas!!, prevKey = preKey, nextKey = pageNum + 1)
//
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
    }
}