package com.gurpreetsk.android_starter._storage.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class AppPrefs(private val context: Context) : AppSettings {
    private val preferences: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(context)
    }

    override fun putString(key: String, value: String) =
            preferences.edit()
                    .putString(key, value)
                    .apply()

    override fun getString(key: String, defaultValue: String): String? =
            preferences.getString(key, defaultValue)
}
