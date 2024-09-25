package com.android.warpshuttle.data.network

import com.android.warpshuttle.data.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("user/sign-in/")
    fun verifyLogin(
        @Field("email") email: String,
        @Field("password") password: String?
    ): Call<User>

}