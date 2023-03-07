package com.lilly.datastore.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("name")
class StudentPrefImpl(private val context: Context) : StudentPref{
    override fun getName(): Flow<String> {
        return context.dataStore.data.map {
            it[NAME_KEY]?: ""
        }
    }

    override suspend fun saveName(name: String) {
        context.dataStore.edit {
            it[NAME_KEY]=name
        }
    }
}