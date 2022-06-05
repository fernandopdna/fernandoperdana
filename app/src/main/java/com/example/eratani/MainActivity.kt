package com.example.eratani

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.eratani.task1.Task1
import com.example.eratani.task2.Task2
import com.example.eratani.task3.Task3
import com.example.eratani.task4.Task4
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTask1.setOnClickListener(this)
        btnTask2.setOnClickListener(this)
        btnTask3.setOnClickListener(this)
        btnTask4.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnTask1 -> {
                val intent = Intent(this, Task1::class.java)
                startActivity(intent)
            }
            R.id.btnTask2 -> {
                val intent = Intent(this, Task2::class.java)
                startActivity(intent)
            }
            R.id.btnTask3 -> {
                val intent = Intent(this, Task3::class.java)
                startActivity(intent)
            }
            R.id.btnTask4 -> {
                val intent = Intent(this, Task4::class.java)
                startActivity(intent)
            }
        }

    }


}