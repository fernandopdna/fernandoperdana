package com.example.eratani.task4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eratani.R
import kotlinx.android.synthetic.main.activity_task4.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class Task4 : AppCompatActivity() {

    private val list = ArrayList<Resoponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4)

        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        val decorator = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
        decorator.setDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.line)!!)
        rvPost.addItemDecoration(decorator)

        RetrofitClient.instance.getPosts().enqueue(object : Callback<ArrayList<Resoponse>> {
            override fun onResponse(
                call: Call<ArrayList<Resoponse>>,
                response: Response<ArrayList<Resoponse>>
            ) {
                progress_indikator.visibility = View.GONE
                response.body()?.let { list.addAll(it) }
                val adapter = PostAdapter(list)
                rvPost.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<Resoponse>>, t: Throwable) {
                progress_indikator.visibility = View.GONE
                Toast.makeText(this@Task4, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        btnPermission.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }


}