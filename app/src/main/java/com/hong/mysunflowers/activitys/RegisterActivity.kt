package com.hong.mysunflowers.activitys

import android.view.View
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.ToastUtils
import com.hong.mysunflowers.R
import com.hong.mysunflowers.app.NICK_NAME
import com.hong.mysunflowers.base.BaseActivity
import com.hong.mysunflowers.base.BaseResponse
import com.hong.mysunflowers.base.DataState
import com.hong.mysunflowers.bean.LoginRegisterBean
import com.hong.mysunflowers.https.ApiService
import com.hong.mysunflowers.repositorys.RegisterRepository
import com.hong.mysunflowers.utils.SpUtils
import com.hong.mysunflowers.viewmodels.RegisterViewModel
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 注册
 */

class RegisterActivity : BaseActivity() {

    private val viewModel: RegisterViewModel by lazy {
        RegisterViewModel(RegisterRepository(ApiService.create()))
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun init() {
        initListener()
        initObserver()
    }

    private fun initListener() {
        tv_register.visibility = View.GONE
        tv_title.text = "注册"
        bt_login.setOnClickListener {
            viewModel.register(et_name.text.toString(),
                et_pwd.text.toString(), et_pwd_again.text.toString())
        }
    }

    private fun initObserver() {
        // 订阅
        val observer = Observer<BaseResponse<LoginRegisterBean>> {
            when (it.dataState) {
                DataState.STATE_LOADING -> {
                    showLoading(false)
                }
                DataState.STATE_SUCCESS -> {
                    dismissLoading()
                    ToastUtils.showShort("注册成功")
                    SpUtils.put(NICK_NAME, it.data?.nickname)
                    finish()
                }
                DataState.STATE_FAILED -> {
                    dismissLoading()
                    ToastUtils.showShort(it.errorMsg)
                }
                DataState.STATE_ERROR -> {
                    showLoading(false)
                }
                else -> {
                    ToastUtils.showShort(it.error.toString())
                }
            }
        }
        viewModel.registerLiveData.observe(this, observer)
    }
}