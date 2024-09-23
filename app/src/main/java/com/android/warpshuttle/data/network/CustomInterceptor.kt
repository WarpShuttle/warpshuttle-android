package com.android.warpshuttle.data.network

import com.facebook.stetho.BuildConfig
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException
import javax.net.ssl.SSLHandshakeException
import javax.net.ssl.SSLProtocolException

class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.header(
            "X-Accept-Version",
            BuildConfig.VERSION_NAME
        )
        requestBuilder.header("Content-Type", "application/json")
        requestBuilder.header("Accept", "application/json")
        requestBuilder.header("Device", "ANDROID")
        requestBuilder.header("VersionName", BuildConfig.VERSION_NAME)
        return try {
            chain.proceed(requestBuilder.build())
        } catch (e: UnknownHostException) {
            e.printStackTrace()
            Response.Builder()
                .request(Request.Builder().url("http://127.0.0.1:8000/api/v1").build())
                .protocol(Protocol.HTTP_2).message("UnknownHostException").body(
                    "{\"key\":[\"Just Handling DNS exception\"]}"
                        .toResponseBody("application/json".toMediaTypeOrNull())
                ).code(400).build()
        } catch (e1: SocketTimeoutException) {
            e1.printStackTrace()
            Response.Builder()
                .request(Request.Builder().url("http://127.0.0.1:8000/api/v1").build())
                .protocol(Protocol.HTTP_2).message("SocketTimeoutException").body(
                    "{\"key\":[\"Just Handling SocketTimeOut exception\"]}"
                        .toResponseBody("application/json".toMediaTypeOrNull())
                ).code(400).build()
        } catch (e2: SocketException) {
            e2.printStackTrace()
            Response.Builder()
                .request(Request.Builder().url("http://127.0.0.1:8000/api/v1").build())
                .protocol(Protocol.HTTP_2).message("SocketException").body(
                    "{\"key\":[\"Just Handling Socket exception\"]}"
                        .toResponseBody("application/json".toMediaTypeOrNull())
                ).code(400).build()
        } catch (e3 : SSLException){
            e3.printStackTrace()
            Response.Builder()
                .request(Request.Builder().url("http://127.0.0.1:8000/api/v1").build())
                .protocol(Protocol.HTTP_2).message("SSLException").body(
                    "{\"key\":[\"Just Handling SSL exception\"]}"
                        .toResponseBody("application/json".toMediaTypeOrNull())
                ).code(400).build()
        } catch (e4 : Exception){
            e4.printStackTrace()
            Response.Builder()
                .request(Request.Builder().url("http://127.0.0.1:8000/api/v1").build())
                .protocol(Protocol.HTTP_2).message("Exception").body(
                    "{\"key\":[\"Just Handling Generic exception\"]}"
                        .toResponseBody("application/json".toMediaTypeOrNull())
                ).code(400).build()
        }catch (e5 : IOException){
            e5.printStackTrace()
            Response.Builder()
                .request(Request.Builder().url("https://idealofmed.bonzun.com").build())
                .protocol(Protocol.HTTP_2).message("IOException").body(
                    "{\"key\":[\"Just Handling IO exception\"]}"
                        .toResponseBody("application/json".toMediaTypeOrNull())
                ).code(400).build()
        }
        catch (e6 : SSLHandshakeException){
            e6.printStackTrace()
            Response.Builder()
                .request(Request.Builder().url("http://127.0.0.1:8000/api/v1").build())
                .protocol(Protocol.HTTP_2).message("SSLHandshakeException").body(
                    "{\"key\":[\"Just Handling SSLHandshakeException exception\"]}"
                        .toResponseBody("application/json".toMediaTypeOrNull())
                ).code(400).build()
        }
        catch (e7 : SSLProtocolException){
            e7.printStackTrace()
            Response.Builder()
                .request(Request.Builder().url("http://127.0.0.1:8000/api/v1").build())
                .protocol(Protocol.HTTP_2).message("SSLProtocolException").body(
                    "{\"key\":[\"Just Handling SSLProtocolException exception\"]}"
                        .toResponseBody("application/json".toMediaTypeOrNull())
                ).code(400).build()
        }
    }
}