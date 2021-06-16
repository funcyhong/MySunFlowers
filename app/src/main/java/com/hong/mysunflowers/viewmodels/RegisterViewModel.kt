package com.hong.mysunflowers.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hong.mysunflowers.app.IS_LOGIN
import com.hong.mysunflowers.app.USER_NAME
import com.hong.mysunflowers.base.BaseLiveData
import com.hong.mysunflowers.bean.LoginRegisterBean
import com.hong.mysunflowers.repositorys.RegisterRepository
import com.hong.mysunflowers.utils.SpUtils
import kotlinx.coroutines.launch

class RegisterViewModel(private val repoRegister: RegisterRepository) : ViewModel() {

    val registerLiveData = BaseLiveData<LoginRegisterBean>()
    val loginLiveData = BaseLiveData<LoginRegisterBean>()

    fun register(username: String, password: String, repassword: String) {
        viewModelScope.launch {
            repoRegister.register(username, password, repassword, registerLiveData)
        }
    }

    fun login(username: String, password: String) {
        // 这里不需要手动去取消协程，会在该 view model 销毁时自动取消
        viewModelScope.launch {
            repoRegister.login(username, password, loginLiveData)
        }
    }

    fun save(data: LoginRegisterBean) {
        SpUtils.put(USER_NAME, data.username)
        SpUtils.put(IS_LOGIN, true)
    }

}