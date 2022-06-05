package com.example.eratani.task4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eratani.R
import kotlinx.android.synthetic.main.item_list.view.*
import java.util.ArrayList

class PostAdapter(private val list: ArrayList<Resoponse>):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(resoponse: Resoponse){
            with(itemView){
                    tvName.text = resoponse.name
                    tvEmail.text = resoponse.email
                    tvGender.text = resoponse.gender
                    tvStatus.text = resoponse.status
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }


}