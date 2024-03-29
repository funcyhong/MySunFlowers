package com.hong.mysunflowers.dialogs

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import com.hong.mysunflowers.R

/**
 * 加载框
 */
class LoadingDialog(context: Context, var canNotCancel: Boolean) : Dialog(
    context,
    R.style.LoadingDialog
) {

    private var loadingDialog: LoadingDialog? = null

    init {
        setContentView(R.layout.dialog_loading_view)
        val imageView: ImageView = findViewById(R.id.iv_image)
        val animation: Animation = RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animation.duration = 2000
        animation.repeatCount = 10
        animation.fillAfter = true
        imageView.startAnimation(animation)
    }

    fun showDialog(context: Context, isCancel: Boolean) {
        if (context is Activity) {
            if (context.isFinishing) {
                return
            }
        }

        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(context, isCancel)
        }
        loadingDialog?.setCancelable(isCancel)
        loadingDialog?.show()
    }

    fun dismissDialog() {
        loadingDialog?.dismiss()
    }

}