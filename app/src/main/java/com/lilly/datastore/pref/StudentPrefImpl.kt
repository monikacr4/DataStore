package com.lilly.datastore.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("name_prefs")
class StudentPrefImpl(private val context: Context){

    companion object{
        val NAME_KEY = stringPreferencesKey("STUDENT_NAME")
        val MARKS_KEY = intPreferencesKey("STUDENT_MARKS")
        val STATUS_KEY = booleanPreferencesKey("STUDENT_STATUS")
    }
    suspend fun saveInfo(name: String, marks: Int, status: Boolean) {
        context.dataStore.edit {
            it[NAME_KEY]=name
            it[MARKS_KEY] = marks
            it[STATUS_KEY] = status

        }
    }

    val nameFlow: Flow<String> = context.dataStore.data.map{
        it[NAME_KEY] ?: ""
    }

    val marksFlow: Flow<Int> = context.dataStore.data.map{
        it[MARKS_KEY] ?: 0
    }

    val statusFlow: Flow<Boolean> = context.dataStore.data.map{
        it[STATUS_KEY] ?: false
    }
}