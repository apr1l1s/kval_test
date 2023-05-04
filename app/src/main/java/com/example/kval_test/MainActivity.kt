package com.example.kval_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kval_test.base.MainDb
import com.example.kval_test.databinding.ActivityMainBinding
import com.example.kval_test.recycler_view.PostAdapter
import com.example.kval_test.server.ServerApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    fun getAll(){
        CoroutineScope(Dispatchers.IO).launch {
            val db = MainDb.getDb(this@MainActivity)
            val list = ServerApi.retrofit.getAllPosts().list
            val g = findViewById<RecyclerView>(R.id.recyclerView)
            runOnUiThread {
                g.adapter = PostAdapter(list)
                g.layoutManager = LinearLayoutManager(this@MainActivity)
            }
            db.getDao().deleteAllItems()
            list.forEach {
                db.getDao().insertItem(it)
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAll()
        binding.searchButton.setOnClickListener {
            getAll()
        }
    }
}