package com.android.warpshuttle.data.network

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException
import java.net.SocketException
import javax.net.ssl.SSLException


class ResponseTypeAdapterFactory : TypeAdapterFactory {

    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T> {
        val delegateAdapter = gson.getDelegateAdapter(this, type)
        val jsonElementAdapter = gson.getAdapter(JsonElement::class.java)

        return object : TypeAdapter<T>() {
            @Throws(IOException::class)
            override fun write(out: JsonWriter, value: T) {
                delegateAdapter.write(out, value)
            }

            @Throws(IOException::class)
            override fun read(`in`: JsonReader): T {
                try {
                    // Ignore extraneous data and read in only the response data when the response is a success
                    var jsonElement = jsonElementAdapter.read(`in`)
                    if (jsonElement.isJsonObject) {
                        val jsonObject = jsonElement.asJsonObject
                        if (jsonObject.has(STATUS)) {
                            if (jsonObject.get(STATUS) !is JsonNull)
                                if (jsonObject.get(STATUS).asString == SUCCESS) {
                                    if (jsonObject.has(DATA) && (jsonObject.get(DATA).isJsonObject || jsonObject.get(
                                            DATA
                                        ).isJsonArray)
                                    ) {
                                        jsonElement = jsonObject.get(DATA)
                                    }
                                }

                        }
                    }
                    return delegateAdapter.fromJsonTree(jsonElement)

                } catch (e: SocketException) {
                    // Handle SocketException here
                    Log.i("SocketException", "Caught SocketException: ${e.message}")
                    // throw e  // Rethrow the exception if needed
//                    Firebase.crashlytics.log("${e.message}")
                    return null as T
                } catch ( ex1 : SSLException){
                    // Handle SocketException here
                    Log.i("SSL Exception", "Caught SocketException: ${ex1.message}")
                    // throw e  // Rethrow the exception if needed
//                    Firebase.crashlytics.log("${ex1.message}")
                    return null as T
                }
            }
        }.nullSafe()
    }

    companion object {
        private const val STATUS = "status"
        private const val SUCCESS = "success"
        private const val DATA = "data"
    }
}