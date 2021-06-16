package com.hong.mysunflowers.fragments

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.hong.mysunflowers.R
import com.hong.mysunflowers.adapters.SystemBodyAdapter
import com.hong.mysunflowers.base.BaseFragment
import com.hong.mysunflowers.https.ApiService
import com.hong.mysunflowers.repositorys.SystemRepository
import com.hong.mysunflowers.viewmodels.SystemViewModel
import kotlinx.android.synthetic.main.fragment_answers.*
import kotlinx.coroutines.flow.collectLatest

/**
 * Created by funcyhong
 * Date 2021/6/16 11:53
 * Description 体系主界面 - 体系界面
 */
class SystemBodyFragment : BaseFragment(){

    private val bodyViewModel by lazy {
        SystemViewModel(SystemRepository(ApiService.create()))
    }

    private lateinit var adapter : SystemBodyAdapter

    override fun init() {
        initRecycler()
        getBodyList()
    }

    private fun initRecycler() {
        adapter = SystemBodyAdapter()
        rv_answers.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        rv_answers.adapter = adapter
    }

    private fun getBodyList() {
        lifecycleScope.launchWhenCreated {
            bodyViewModel.getBodyList().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_answers
    }
}