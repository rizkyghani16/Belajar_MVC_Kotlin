package com.uwacoding.belajarkotlin

import android.app.Application
import com.uwacoding.belajarkotlin.repository.DbHelper

class TodoApplication : Application() {

    public var db: DbHelper = DbHelper(this)
    override fun onCreate() {
        super.onCreate()

    }
}