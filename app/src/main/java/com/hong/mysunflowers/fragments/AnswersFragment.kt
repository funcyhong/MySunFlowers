package com.hong.mysunflowers.fragments

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hong.mysunflowers.R
import com.hong.mysunflowers.adapters.AnswersAdapter
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
        initObserver()
        getAnswersList()
    }

    private fun initRecycler() {
        rv_answers.layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        adapter = AnswersAdapter(AnswersDiffCallBack())
        rv_answers.adapter = adapter
    }

    private fun initObserver() {
        val observer = Observer<BaseResponse<AnswersResponse>> {
            when (it.dataState) {
                DataState.STATE_LOADING ->
                    println("STATE_LOADING")
                DataState.STATE_SUCCESS ->
                    adapter.submitList(it?.data?.datas)
                else ->
                    println(it.dataState)
            }

        }
        answersViewModel.answersList.observe(this, observer)
    }

    private fun getAnswersList() {
        answersViewModel.getAnswersList(0)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_answers
    }
}