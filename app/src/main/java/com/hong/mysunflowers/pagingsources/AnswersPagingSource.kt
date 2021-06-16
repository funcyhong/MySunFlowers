package com.hong.mysunflowers.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hong.mysunflowers.bean.PageBean
import com.hong.mysunflowers.https.ApiService

/**
 * @instruction： 问答数据源，主要配合Paging3进行数据请求与显示
 */
class AnswersPagingSource(private val service: ApiService) :
    PagingSource<Int, PageBean>() {

    override fun getRefreshKey(state: PagingState<Int, PageBean>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PageBean> {
        return try {
            val pageNum = params.key ?: 1
            val data = service.getAnswersList(pageNum)
            val preKey = if (pageNum > 1) pageNum - 1 else null
            LoadResult.Page(data.data?.datas!!, prevKey = preKey, nextKey = pageNum + 1)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}