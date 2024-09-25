package com.android.warpshuttle.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.Log
import com.android.warpshuttle.data.model.User
import com.android.warpshuttle.data.network.ApiService
import com.android.warpshuttle.data.network.SingleLiveEvent
import com.android.warpshuttle.data.pref.readBool
import com.android.warpshuttle.data.pref.writeBool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(
    private val remoteDataSourceApiService: ApiService,
    val apiKey: String? = null,
    private val context: Context
) {
    val introViewedStateFromPref = context.readBool(IS_INTRO_VIEWED)
    val loggedInStateFromPref = context.readBool(IS_LOGGED_IN)

    suspend fun saveIntroViewedStatus(isIntroViewed: Boolean) {
        context.writeBool(IS_INTRO_VIEWED, isIntroViewed)
    }

    suspend fun saveLoginStatus(isLoggedIn: Boolean) {
        context.writeBool(IS_LOGGED_IN, isLoggedIn)
    }

    fun verifyLogin(
        email: String,
        password: String
    ): SingleLiveEvent<ResponseEvent> {
        val responseData = SingleLiveEvent<ResponseEvent>()

        responseData.postValue(ResponseEvent(isLoading = true))
        val callable: Call<User> =
            remoteDataSourceApiService.verifyLogin( email, password)
        callable.enqueue(object :
            Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    responseData.value =
                        ResponseEvent(isSuccess = true, serverResponseData = response.body())
                } else {
                    responseData.value =
                        ResponseEvent(isSuccess = false, error = response)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.i("UserInformation", "Response ${t.cause}  $t")
            }

        })
        return responseData
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: UserRepository? = null
        const val IS_INTRO_VIEWED = "intro_viewed"
        const val IS_LOGGED_IN = "logged_in"

        fun getInstance(
            apiService: ApiService,
            apiKey: String? = null,
            context: Context
        ): UserRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE?.let {
                    return it
                }
                val onboard = UserRepository(apiService, apiKey, context)
                INSTANCE = onboard
                onboard
            }
        }
    }
}


data class ResponseEvent(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val serverResponseData: User? = null,
    val error: Any? = null,
    val errorMessage: String? = null
)

