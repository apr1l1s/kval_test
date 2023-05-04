package com.example.kval_test.base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {
    @Insert
    fun insertItem(item:Post)
    @Query("SELECT * FROM posts")
    fun getAllItems(): Flow<Post>
    @Query("DELETE FROM posts")
    fun deleteAllItems()
}