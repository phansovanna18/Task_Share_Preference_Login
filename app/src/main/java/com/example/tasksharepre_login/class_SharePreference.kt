package com.example.tasksharepre_login

import android.content.Context
import android.content.SharedPreferences

class class_SharePrefernce(context: Context){

    private val preference:SharedPreferences
    private val editPreference:SharedPreferences.Editor
    private val preferenceName = "MyLogin"
    private val preferenceObjUser = "user"
    private val preferenceObjPassword = "password"
    private val preferenceObjLogin = "login"

    init {
        preference = context.getSharedPreferences(preferenceName,Context.MODE_PRIVATE)
        editPreference = preference.edit()
    }

    fun getUser(): String? {
        return preference.getString(preferenceObjUser,"")
    }

    fun getPassword():String?{
        return preference.getString(preferenceObjPassword,"")
    }

    fun getLogin():Boolean?{
        return preference.getBoolean(preferenceObjLogin,false)
    }

    fun putUser(user:String){
        editPreference.putString(preferenceObjUser,user)
        editPreference.apply()
    }

    fun putPassword(password:String){
        editPreference.putString(preferenceObjPassword,password)
        editPreference.apply()
    }

    fun putLogin(b:Boolean){
        editPreference.putBoolean(preferenceObjLogin,b)
        editPreference.apply()
    }
}