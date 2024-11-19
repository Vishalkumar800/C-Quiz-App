package com.rach.co.roomDatabase

import android.app.Application

class ProfileApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}