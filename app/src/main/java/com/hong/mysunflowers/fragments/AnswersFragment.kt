package com.hong.mysunflowers.fragments

import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.hong.mysunflowers.R
import com.hong.mysunflowers.adapters.AnswersAdapter
import com.hong.mysunflowers.adapters.FooterAdapter
import com.hong.mysunflowers.base.BaseFragment
import com.hong.mysunflowers.base.BaseResponse
import com.hong.mysunflowers.base.DataState
import com.hong.mysunflowers.bean.AnswersResponse
import com.hong.mysunflowers.diffs.AnswersDiffCallBack
import com.hong.mysunflowers.entitys.AnswersEntity
import com.hong.mysunflowers.https.ApiService
import com.hong.mysunflowers.repositorys.AnswersRepository
import com.hong.mysunflowers.viewmodels.AnswersViewModel
import kotlinx.android.synthetic.main.fragment_answers.*
import kotlinx.coroutines.flow.collectLatest

/**
 * 问答界面
 */
class AnswersFragment : BaseFragment() {

    private lateinit var adapter: AnswersAdapter
    private val answersViewModel: AnswersViewModel by lazy {
        AnswersViewModel(AnswersRepository(ApiService.create()))
    }

    override fun init() {
        initRecycler()
        getAnswersList()
    }

    private fun initRecycler() {
        adapter = AnswersAdapter(AnswersDiffCallBack())
        adapter.withLoadStateFooter(FooterAdapter {
            adapter.retry()
        })
        lifecycleScope.launchWhenCreated {
            adapter.loadStateFlow.collectLatest {
                it.refresh is LoadState.Loading
            }
        }
        rv_answers.apply {
            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            adapter = this@AnswersFragment.adapter
        }
    }

    private fun getAnswersList() {
        lifecycleScope.launchWhenCreated {
            answersViewModel.getAnswersList().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_answers
    }
}