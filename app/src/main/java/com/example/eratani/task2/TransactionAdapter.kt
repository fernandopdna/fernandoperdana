package com.example.eratani.task2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eratani.R

class TransactionAdapter(private val transactionList :ArrayList<Transaction>) : RecyclerView.Adapter<TransactionAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_transaction, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenItem = transactionList[position]
        holder.trKet.text = currenItem.ket_barang
        holder.trDate.text = currenItem.tgl_barang
        holder.trQty.text = currenItem.qty_barang.toString()
    }

    override fun getItemCount(): Int {
        return  transactionList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val trKet: TextView = itemView.findViewById(R.id.tvTrKet)
        val trDate: TextView = itemView.findViewById(R.id.tvDate)
        val trQty: TextView = itemView.findViewById(R.id.tvQty)
    }
}