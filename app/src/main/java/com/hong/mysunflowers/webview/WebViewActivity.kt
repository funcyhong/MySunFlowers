package com.hong.mysunflowers.webview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.hong.mysunflowers.R
import com.hong.mysunflowers.base.BaseActivity
import com.hong.mysunflowers.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_web_view.*

/**
 * Created by funcyhong
 * Date 2021/6/22 11:00
 * Description 展示 web view 界面
 */

class WebViewActivity : BaseActivity() {

    companion object {

        private const val URL_PATH = "url_path"

        fun startActivity(activity: Context, url: String) {
            val intent = Intent(activity, WebViewActivity::class.java)
            intent.putExtra(URL_PATH, url)
            activity.startActivity(intent)
        }
    }

    private lateinit var webView : WebView
    private var url: String? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_web_view
    }

    override fun init() {
        initIntentData()
        initWebView()
    }

    private fun initIntentData() {
        url = intent?.getStringExtra(URL_PATH).toString()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        if (url.isNullOrEmpty()) {
            ToastUtil.show("路径异常")
            return
        }
        webView = WebView(this)
        val layoutParams: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        webView.layoutParams = layoutParams
        fl_web_view.addView(webView)

        val webSetting = webView.settings
        webSetting.domStorageEnabled = true
        webSetting.useWideViewPort = true
        webSetting.loadWithOverviewMode = true
        webSetting.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url == null) {
                    return false
                }
                try {
                    if (url.startsWith("weixin://") || url.startsWith("jianshu://")) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(intent)
                        return true
                    }
                } catch (e: Exception) {
                    return true
                }
                view?.loadUrl(url)
                return true
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                progress_bar.isVisible = newProgress != 100
                progress_bar.progress = newProgress
            }
        }
        webView.loadUrl(url)
    }
}