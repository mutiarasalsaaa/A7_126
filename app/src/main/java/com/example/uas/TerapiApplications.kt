package com.example.uas

import android.app.Application
import com.example.uas.dependenciesinjection.AppContainer
import com.example.uas.dependenciesinjection.reflexyContainer

class TerapiApplications: Application() {
    lateinit var container : AppContainer
    override fun onCreate() {
        super.onCreate()
        container=reflexyContainer()
    }
}