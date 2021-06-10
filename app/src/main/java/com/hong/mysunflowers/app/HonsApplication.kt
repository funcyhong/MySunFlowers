package com.hong.mysunflowers.app

import android.app.Application
import android.content.Context

/**
 * Application
 */
class HonsApplication : Application() {

    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}