package com.avoxis.diskominfointerview.helper

import android.content.Context
import android.content.SharedPreferences
import android.media.session.MediaSession.Token
import com.avoxis.diskominfointerview.BuildConfig


class SessionManager(context: Context) {

    private var pref: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    private val TOKEN = "token"
    private val EMAIL = "email"

    init {
        pref = context.getSharedPreferences("AppPref", Context.MODE_PRIVATE)
        editor = pref?.edit()
        editor?.apply()
    }

    fun setToken(value: String?) {
        editor!!.putString(TOKEN, value)
        editor!!.commit()
    }

    fun getToken(): String? {
        return pref!!.getString(TOKEN, "")
    }

    fun setEmail(value: String?) {
        editor!!.putString(EMAIL, value)
        editor!!.commit()
    }

    fun getEmail(): String? {
        return pref!!.getString(EMAIL, "")
    }
}