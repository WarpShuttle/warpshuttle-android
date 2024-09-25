package com.android.warpshuttle.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class User : Serializable {
    @SerializedName("id")
    var id: Int = 0

    var email: String? = null

    @SerializedName("api_token")
    var token: String = ""
}