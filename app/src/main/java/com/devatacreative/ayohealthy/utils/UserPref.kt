package com.devatacreative.ayohealthy.utils

import android.content.Context
import com.devatacreative.ayohealthy.model.UserPrefModel

internal class UserPref(context: Context) {
    companion object{
        private const val PREF_NAME = "USER_PREF"
        private const val NAME = "NAME"
        private const val EMAIL = "EMAIL"
        private const val AVATAR_URL = "AVATAR_URL"
//        private const val PHONE = "PHONE"
        private const val ID = "ID"
        private const val ID_TOKEN = "ID_TOKEN"
    }
    private val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setUser(user: UserPrefModel){
        val editor = prefs.edit()
        editor.putString(NAME, user.name)
        editor.putString(EMAIL, user.email)
        editor.putString(AVATAR_URL, user.avatarUrl)
//        editor.putString(PHONE, user.phone)
        editor.putString(ID, user.id)
        editor.putString(ID_TOKEN, user.idToken)
        editor.apply()
    }

    fun getUser(): UserPrefModel {
        val name = prefs.getString(NAME, "")
        val email = prefs.getString(EMAIL, "")
        val avatar = prefs.getString(AVATAR_URL, "")
//        val phone = prefs.getString(PHONE, "")
        val id = prefs.getString(ID, "")
        val idToken = prefs.getString(ID_TOKEN, "")
        return UserPrefModel(
            id, idToken, name, email, avatar
        )
    }
}