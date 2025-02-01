package com.example.mapd721_a1_divyanshoosinha.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userToken")
        private val USER_TOKEN_KEY = stringPreferencesKey("user_token")
        private val USER_NAME_KEY = stringPreferencesKey("user_name")
        private val USER_ID_KEY = stringPreferencesKey("user_id")
    }

    val getAccessToken: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[USER_TOKEN_KEY] ?: ""
    }

    val getUsername: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[USER_NAME_KEY] ?: ""
    }

    val getUserId: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[USER_ID_KEY] ?: ""
    }


//    suspend fun saveToken(token: String, username: String, studentId: String) {    //
//        context.dataStore.edit { preferences ->
//            preferences[USER_TOKEN_KEY] = token
//            preferences[USER_NAME_KEY] = username
//            preferences[USER_ID_KEY] = studentId
//        }
//    }


    suspend fun saveToken(token: String, username: String, studentId: String) {    //
        context.dataStore.edit { preferences ->
            preferences[USER_TOKEN_KEY] = token
            preferences[USER_NAME_KEY] = username
            preferences[USER_ID_KEY] = studentId
        }
    }

    suspend fun saveUsername(token: String, username: String, studentId: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_TOKEN_KEY] = token
            preferences[USER_NAME_KEY] = username
            preferences[USER_ID_KEY] = studentId
        }
    }

    suspend fun saveStudentID(token: String, username: String, studentId: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_TOKEN_KEY] = token
            preferences[USER_NAME_KEY] = username
            preferences[USER_ID_KEY] = studentId
        }
    }

}