package com.example.eratani.task4

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val BASE_URL = "https://gorest.co.in/public/v2/"

    private var client = OkHttpClient.Builder().addInterceptor { chain ->
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer 5806e30ba9c85b649c28119caa8cd0aa235797ab4df1ecf4098b3cbecd023a1b")
            .build()
        chain.proceed(newRequest)
    }.build()

    val instance: ApiInterface by lazy {
        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        retrofit.create(ApiInterface::class.java)

    }
}