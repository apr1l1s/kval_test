package com.example.kval_test.base

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Post (
    @PrimaryKey
    var post_id:Int,
    @ColumnInfo(name= "title")
    var title:String,
    @ColumnInfo(name="text")
    var text:String
)