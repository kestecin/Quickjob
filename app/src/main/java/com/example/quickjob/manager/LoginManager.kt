package com.example.quickjob.manager

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager


class LoginManager {
    companion object SaveSharedPreference {
        val PREF_USER_NAME = "username"

        fun getSharedPreferences(ctx: Context?): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(ctx)
        }

        fun setUserName(ctx: Context?, userName: String?) {
            val editor: SharedPreferences.Editor = getSharedPreferences(ctx).edit()
            editor.putString(PREF_USER_NAME, userName)
            editor.apply()
        }

        fun getUserName(ctx: Context?): String? {
            return getSharedPreferences(ctx).getString(PREF_USER_NAME, "")
        }
    }
}