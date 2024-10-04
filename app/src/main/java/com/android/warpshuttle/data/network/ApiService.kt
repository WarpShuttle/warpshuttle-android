package com.android.warpshuttle.data.network

import com.android.warpshuttle.data.model.User
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("user/sign-in/")
    fun verifyLogin(
        @Field("email") email: String,
        @Field("password") password: String?
    ): Call<User>

//    @GET("team/team-members/")
//    fun getAllTeamMember(
//        @Header("Authorization") token: String,
//    ): ArrayList<Team>
}