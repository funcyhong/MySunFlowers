package com.hong.mysunflowers.fragments

import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.hong.mysunflowers.R
import com.hong.mysunflowers.adapters.AnswersAdapter
import com.hong.mysunflowers.adapters.FooterAdapter
import com.hong.mysunflowers.base.BaseFragment
import com.hong.mysunflowers.diffs.AnswersDiffCallBack
import com.hong.mysunflowers.https.ApiService
import com.hong.mysunflowers.repositorys.AnswersRepository
import com.hong.mysunflowers.viewmodels.AnswersViewModel
import kotlinx.android.synthetic.main.fragment_answers.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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

        viewLifecycleOwner.lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest { loadStates ->
                loadStates.refresh is LoadState.Loading
                loadStates.prepend
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
        viewLifecycleOwner.lifecycleScope.launch {
            answersViewModel.getAnswersList().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_answers
    }
}