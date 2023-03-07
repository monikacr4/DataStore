package com.lilly.datastore.pref

import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow

val NAME_KEY = stringPreferencesKey("name")
interface StudentPref {
    fun getName(): Flow<String>

    suspend fun saveName(name:String)
}