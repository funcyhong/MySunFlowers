package com.hong.mysunflowers.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hong.mysunflowers.dialogs.LoadingDialog
import com.hong.mysunflowers.views.StatusBar

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var mLoadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mLoadingDialog = LoadingDialog(this, false)
        StatusBar().fitSystemBar(this)
        init()
    }

    fun showLoading(canCancel: Boolean) {
        mLoadingDialog.showDialog(this, canCancel)
    }

    fun dismissLoading(){
        mLoadingDialog.dismissDialog()
    }

    abstract fun getLayoutId(): Int

    abstract fun init()
}