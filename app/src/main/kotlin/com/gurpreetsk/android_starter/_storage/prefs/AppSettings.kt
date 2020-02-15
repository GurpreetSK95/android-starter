package com.gurpreetsk.android_starter._storage.prefs

interface AppSettings {
    fun putString(key: String, value: String)
    fun getString(key: String, defaultValue: String): String?
}
