package com.android.warpshuttle.data.repository

import android.annotation.SuppressLint
import android.content.Context
import com.android.warpshuttle.data.pref.readBool
import com.android.warpshuttle.data.pref.writeBool

class UserRepository(private val context: Context) {
    val introViewedStateFromPref = context.readBool(IS_INTRO_VIEWED)

    suspend fun saveIntroViewedStatus(isIntroViewed: Boolean) {
        context.writeBool(IS_INTRO_VIEWED, isIntroViewed)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: UserRepository? = null
        const val IS_INTRO_VIEWED = "intro_viewed"

        public fun getInstance(
            context: Context
        ): UserRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE?.let {
                    return it
                }
                val onboard = UserRepository( context)
                INSTANCE = onboard
                onboard
            }
        }
    }
}

