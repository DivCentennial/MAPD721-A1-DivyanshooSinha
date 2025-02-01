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
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userData")
        private val USER_COURSE_KEY = stringPreferencesKey("user_course")
        private val USER_NAME_KEY = stringPreferencesKey("user_name")
        private val USER_ID_KEY = stringPreferencesKey("user_id")
    }

    val getCourse: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[USER_COURSE_KEY] ?: ""
    }

    val getUsername: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[USER_NAME_KEY] ?: ""
    }

    val getUserId: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[USER_ID_KEY] ?: ""
    }





    suspend fun saveCourse(course: String) {    //  Token
        context.dataStore.edit { preferences ->
            preferences[USER_COURSE_KEY] = course

        }
    }

    suspend fun saveName(username: String) {    //   Name
        context.dataStore.edit { preferences ->

            preferences[USER_NAME_KEY] = username

        }
    }

    suspend fun saveId(studentId: String) {    //  ID
        context.dataStore.edit { preferences ->
           // preferences[USER_TOKEN_KEY] = token
           // preferences[USER_NAME_KEY] = username
            preferences[USER_ID_KEY] = studentId
        }
    }

}