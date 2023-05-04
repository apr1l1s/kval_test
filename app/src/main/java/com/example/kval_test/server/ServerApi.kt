package com.example.kval_test.server

import com.example.kval_test.base.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class GetAllPostsResult(
    var list:List<Post>
)

interface Api {
    @GET("posts")
    suspend fun getAllPosts():GetAllPostsResult
}

class ServerApi {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:10001")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)
    }

}