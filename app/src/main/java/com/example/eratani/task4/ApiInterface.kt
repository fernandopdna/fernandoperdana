package com.example.eratani.task4

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("users")
    fun getPosts(): Call<ArrayList<Resoponse>>


    @FormUrlEncoded
    @POST("users")
    fun createPost(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("gender") gender:String,
        @Field("status") status:String
    ):Call<Resoponse>



}