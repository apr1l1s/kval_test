package com.example.kval_test.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kval_test.base.Post
import com.example.kval_test.databinding.PostItemBinding

class PostAdapter(private val postList: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemBinding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post: Post = postList[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(private val itemBinding: PostItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(post: Post) {
            itemBinding.postText.text = post.text
            itemBinding.postTitle.text = post.title
        }
    }
}