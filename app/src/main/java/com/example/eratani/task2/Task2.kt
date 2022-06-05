package com.example.eratani.task2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eratani.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_task2.*

class Task2 : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var userArrayList: ArrayList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        rvItem.setHasFixedSize(true)
        rvItem.layoutManager = LinearLayoutManager(this)
        val decorator = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
        decorator.setDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.line)!!)
        rvItem.addItemDecoration(decorator)

        userArrayList = arrayListOf()
        getItemData()
    }

    private fun getItemData() {
        dbref = FirebaseDatabase.getInstance().reference.child("Barang")
        dbref.addValueEventListener(object : ValueEventListener {
           override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(Item::class.java)
                        if (user != null) {
                            user.key_item = userSnapshot.key
                        }
                        Item(key_item = "userSnapshot.key")
                        userArrayList.add(user!!)

                    }
                    progress_indikator_task2.visibility = View.GONE
                    rvItem.adapter = ItemAdapter(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}

