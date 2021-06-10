package com.hong.mysunflowers.activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.StringUtils
import com.blankj.utilcode.util.ToastUtils
import com.hong.mysunflowers.R
import com.hong.mysunflowers.app.USER_NAME
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
 * 登录
 */
class LoginActivity : BaseActivity() {

    private val viewModel: RegisterViewModel by lazy {
        RegisterViewModel(RegisterRepository(ApiService.create()))
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun init() {
        initViews()
        bt_login.setOnClickListener {
            viewModel.login(et_name.text.toString(), et_pwd.text.toString())
        }
        val observer = Observer<BaseResponse<LoginRegisterBean>> {
            when (it.dataState) {
                DataState.STATE_LOADING -> {
                    showLoading(false)
                }
                DataState.STATE_SUCCESS -> {
                    dismissLoading()
                    ToastUtils.showShort("登录成功")
                    viewModel.save(it.data!!)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
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
        viewModel.loginLiveData.observe(this, observer)
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {
        cl_pwd_again.visibility = View.GONE
        val name = SpUtils.getString(USER_NAME, "")
        if (!StringUtils.isTrimEmpty(name)) {
            et_name.setText(name)
            et_name.setSelection(name!!.length)
        }
        et_pwd.setText("123456789")
        tv_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

}