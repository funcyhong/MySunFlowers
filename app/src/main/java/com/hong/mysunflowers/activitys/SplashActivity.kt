package com.hong.mysunflowers.activitys

import android.R.color
import android.content.Intent
import android.os.Build
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import com.hong.mysunflowers.R
import com.hong.mysunflowers.app.IS_LOGIN
import com.hong.mysunflowers.base.BaseActivity
import com.hong.mysunflowers.utils.SpUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * 闪屏页
 */
class SplashActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun init() {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = resources.getColor(color.transparent)
        lifecycleScope.launch(Dispatchers.IO) {
            delay(1000)
            if (SpUtils.getString(IS_LOGIN).isNullOrBlank()) {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            }
            finish()
        }
    }
}