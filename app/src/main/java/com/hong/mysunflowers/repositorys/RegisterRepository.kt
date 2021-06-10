package com.hong.mysunflowers.repositorys

import com.hong.mysunflowers.base.BaseLiveData
import com.hong.mysunflowers.base.BaseRepository
import com.hong.mysunflowers.bean.LoginRegisterBean
import com.hong.mysunflowers.https.ApiService

/**
 * 注册
 */
class RegisterRepository(private val service: ApiService) : BaseRepository<LoginRegisterBean>() {

    suspend fun register(
        username: String, password: String, repassword: String,
        liveData: BaseLiveData<LoginRegisterBean>
    ) {
        loadRepo({ service.register(username, password, repassword) }, liveData)
    }

    suspend fun login(
        username: String, password: String,
        liveData: BaseLiveData<LoginRegisterBean>
    ) {
        loadRepo({ service.login(username, password) }, liveData)
    }
}