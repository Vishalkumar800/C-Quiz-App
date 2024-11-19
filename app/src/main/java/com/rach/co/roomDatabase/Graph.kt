package com.rach.co.roomDatabase

import android.content.Context
import androidx.room.Room

object Graph {

    lateinit var database: AppDatabase
    val checkingRepository by lazy {
        CheckingRepository(profileDao = database.profileDao())
    }

    fun provide(context: Context){
        database =  Room.databaseBuilder(
            context = context,
            AppDatabase::class.java,
            name = "profile.db"
        ).build()
    }

}