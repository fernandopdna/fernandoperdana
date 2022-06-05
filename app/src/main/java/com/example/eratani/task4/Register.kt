package com.example.eratani.task4

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eratani.R
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnSubmit.setOnClickListener {
            if (etName.text.toString().trim().isEmpty() || etEmail.text.toString().trim()
                    .isEmpty() || etGender.text.toString().trim()
                    .isEmpty() || etStatus.text.toString().trim().isEmpty()
            ) {
                Toast.makeText(this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show()
            } else {
                createPost()
            }
        }

    }

    private fun createPost() {
        RetrofitClient.instance.createPost(
            name = etName.text.toString(),
            email = etEmail.text.toString(),
            gender = etGender.text.toString(),
            status = etStatus.text.toString(),
        ).enqueue(object : Callback<Resoponse> {
            override fun onResponse(
                call: retrofit2.Call<Resoponse>,
                response: Response<Resoponse>
            ) {
                etName.setText("")
                etEmail.setText("")
                etGender.setText("")
                etStatus.setText("")
                Toast.makeText(this@Register, "Data berhasil di upload :)", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onFailure(call: retrofit2.Call<Resoponse>, t: Throwable) {
                Toast.makeText(this@Register, "Data gagal di upload!", Toast.LENGTH_SHORT).show()
            }

        })
    }

}