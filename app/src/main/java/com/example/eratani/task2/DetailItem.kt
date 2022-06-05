package com.example.eratani.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eratani.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail_item.*

class DetailItem : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var transactionArrayList: ArrayList<Transaction>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_item)

        rvTransaction.setHasFixedSize(true)
        rvTransaction.layoutManager = LinearLayoutManager(this)
        val decorator = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
        decorator.setDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.line)!!)
        rvTransaction.addItemDecoration(decorator)

        transactionArrayList = arrayListOf()
        getItemData()
    }
    private fun getItemData() {
        val trId = intent.getStringExtra("idTransaction").toString()
        dbref = FirebaseDatabase.getInstance().reference.child("Barang").child(trId).child("Transaksi")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val transaction = userSnapshot.getValue(Transaction::class.java)
                        transactionArrayList.add(transaction!!)

                    }
                    progress_indikator_detail.visibility = View.GONE
                    rvTransaction.adapter = TransactionAdapter(transactionArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}