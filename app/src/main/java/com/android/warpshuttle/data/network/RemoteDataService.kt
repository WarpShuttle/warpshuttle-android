package com.android.warpshuttle.data.network


import android.util.Log
import com.android.warpshuttle.BuildConfig
import com.facebook.stetho.okhttp.StethoInterceptor
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RemoteDataService {
    private lateinit var apiService: ApiService
    private lateinit var retrofit: Retrofit
    constructor(){
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(10,TimeUnit.MINUTES)
            .writeTimeout(10, TimeUnit.MINUTES)
            .readTimeout(10, TimeUnit.MINUTES)
        if (BuildConfig.DEBUG_MODE) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addNetworkInterceptor(StethoInterceptor()).addInterceptor(logging)
        }

        clientBuilder.addInterceptor(CustomInterceptor())

        retrofitInitialize(clientBuilder)
    }
    fun getRetrofit(): Retrofit {
        return retrofit
    }

    fun getApiService(): ApiService {
        return apiService
    }

    private fun retrofitInitialize(clientBuilder: OkHttpClient.Builder){
        val gson = GsonBuilder()
            .registerTypeAdapterFactory(ResponseTypeAdapterFactory()) // This is the important line ;)
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()

        // Log requests and response
        HttpLoggingInterceptor { message -> // Blacklist the elements not required
            Log.d("RETROFIT", message)
        }


        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(clientBuilder.build()).build()

        apiService = retrofit.create(ApiService::class.java)
    }

}