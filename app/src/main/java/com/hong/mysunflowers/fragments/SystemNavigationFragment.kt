package com.hong.mysunflowers.fragments

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ToastUtils
import com.hong.mysunflowers.R
import com.hong.mysunflowers.adapters.SystemNavigationAdapter
import com.hong.mysunflowers.base.BaseFragment
import com.hong.mysunflowers.base.BaseResponse
import com.hong.mysunflowers.base.DataState
import com.hong.mysunflowers.bean.ArticlesResponse
import com.hong.mysunflowers.https.ApiService
import com.hong.mysunflowers.repositorys.NavigationRepository
import com.hong.mysunflowers.viewmodels.NavigationViewModel
import kotlinx.android.synthetic.main.fragment_answers.*

/**
 * Created by funcyhong
 * Date 2021/6/16 17:07
 * Description 体系主界面 - 导航界面
 */
class SystemNavigationFragment : BaseFragment(){

    private val navigationViewModel by lazy {
        NavigationViewModel(NavigationRepository(ApiService.create()))
    }

    private lateinit var adapter: SystemNavigationAdapter

    override fun init() {
        initRecycler()
        initObserver()
        initData()
    }

    private fun initRecycler() {
        adapter = SystemNavigationAdapter()
        rv_answers.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        rv_answers.adapter = adapter
    }

    private fun initObserver() {
        val observe = Observer<BaseResponse<List<ArticlesResponse>>> {
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
        navigationViewModel.systemNavigationLiveData.observe(this, observe)
    }

    private fun initData() {
        navigationViewModel.getNavigationList()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_answers
    }
}