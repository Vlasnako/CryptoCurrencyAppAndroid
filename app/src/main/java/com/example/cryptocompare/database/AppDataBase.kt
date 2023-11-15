package com.example.cryptocompare.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDataBase : RoomDatabase(){
    companion object {
        private var db: AppDataBase? = null
        private const val DB_NAME = "main_db"
        private val lock = Any()
        fun getInstance(context: Context): AppDataBase {
            synchronized(lock) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(context, AppDataBase::class.java, DB_NAME).build()
                db = instance
                return instance
            }
        }
    }
}