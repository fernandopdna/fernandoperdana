package com.example.eratani.task2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.eratani.R

class ItemAdapter(private val userList :ArrayList<Item>) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_task2, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val context = holder.itemView.context
        val currenItem = userList[position]
        holder.itemId.text = currenItem.key_item
        holder.itemName.text = currenItem.nama_barang
        holder.itemType.text = currenItem.jenis_barang
        holder.btnDetail.setOnClickListener {
            val intent = Intent(
                context,
                DetailItem::class.java
            )
            intent.putExtra("idTransaction", currenItem.key_item.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return  userList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val itemId: TextView = itemView.findViewById(R.id.tvId)
        val itemName: TextView = itemView.findViewById(R.id.tvItem)
        val itemType: TextView = itemView.findViewById(R.id.tvType)
        val btnDetail: CardView = itemView.findViewById(R.id.cvItem)
    }
}