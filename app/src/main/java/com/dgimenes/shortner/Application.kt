package com.dgimenes.shortner

import android.app.Application
import com.dgimenes.shortner.di.BaseComponentGraph
import com.dgimenes.shortner.di.DaggerBaseComponentGraph

class Application : Application() {
    companion object {
        lateinit var componentGraph: BaseComponentGraph
    }

    override fun onCreate() {
        super.onCreate()
        componentGraph = DaggerBaseComponentGraph
                .builder()
                .build()
    }

}