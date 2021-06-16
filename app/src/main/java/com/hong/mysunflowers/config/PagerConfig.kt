package com.hong.mysunflowers.config

import androidx.paging.PagingConfig

/**
 * Created by funcyhong
 * Date 2021/6/16 17:17
 * Description pager 分页配置
 */
class PagerConfig {

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

}