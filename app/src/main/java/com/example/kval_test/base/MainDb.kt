package com.example.kval_test.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Post::class], version = 3)
abstract class MainDb : RoomDatabase() {
    abstract fun getDao():MainDao
    companion object{
        fun getDb(context: Context): MainDb{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java,
                "posts.db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}