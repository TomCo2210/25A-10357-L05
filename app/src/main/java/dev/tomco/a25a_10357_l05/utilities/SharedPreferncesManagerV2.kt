package dev.tomco.a25a_10357_l05.utilities

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManagerV2(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        Constants.SP_keys.PLAYLIST_KEY,
        Context.MODE_PRIVATE
    )


    fun putString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(
            key, defaultValue
        ) ?: defaultValue
    }

}