package com.hong.mysunflowers.fragments

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ToastUtils
import com.hong.mysunflowers.R
import com.hong.mysunflowers.adapters.SystemBodyAdapter
import com.hong.mysunflowers.base.BaseFragment
import com.hong.mysunflowers.base.BaseResponse
import com.hong.mysunflowers.base.DataState
import com.hong.mysunflowers.bean.SystemResponse
import com.hong.mysunflowers.https.ApiService
import com.hong.mysunflowers.repositorys.SystemRepository
import com.hong.mysunflowers.viewmodels.SystemViewModel
import kotlinx.android.synthetic.main.fragment_answers.*

/**
 * Created by funcyhong
 * Date 2021/6/16 11:53
 * Description 体系主界面 - 体系界面
 */
class SystemBodyFragment : BaseFragment() {

    private val bodyViewModel by lazy {
        SystemViewModel(SystemRepository(ApiService.create()))
    }

    private lateinit var adapter: SystemBodyAdapter

    override fun init() {
        initRecycler()
        initObserve()
        getBodyList()
    }

    private fun initObserve() {
        val observe = Observer<BaseResponse<List<SystemResponse>>> {
            when (it.dataState) {
                DataState.STATE_LOADING -> {
                    showLoading()
                }
                DataState.STATE_SUCCESS -> {
                    dismissLoading()
                    adapter.submitList(it.data)
                }
                DataState.STATE_FAILED -> {
                    dismissLoading()
                    ToastUtils.showShort(it.errorMsg)
                }
                DataState.STATE_ERROR -> {
                    dismissLoading()
                }
                else -> {
                    ToastUtils.showShort(it.error.toString())
                }
            }
        }
        bodyViewModel.systemBodyLiveData.observe(this, observe)
    }

    private fun initRecycler() {
        adapter = SystemBodyAdapter()
        rv_answers.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        rv_answers.adapter = adapter
    }

    private fun getBodyList() {
        bodyViewModel.getBodyList()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_answers
    }
}