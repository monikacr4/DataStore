package com.lilly.datastore.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.lilly.datastore.model.Student

class PreferenceRepo(private val context: Context) {
    private val nameKey: String = "name"
    private val marksKey: Int = 0
    private val statusKey: Boolean = false

    companion object{
        private const val sp = "pref"
    }

    fun saveToRepo(student: Student){
        val sharedPref: SharedPreferences =
            context.getSharedPreferences(Companion.sp, MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(nameKey, student.name)
        editor.putInt(marksKey.toString(), student.marks)
        editor.putBoolean(statusKey.toString(),student.status)
        editor.apply()
    }

    fun getFromRepo():Student {
        val sharedPref: SharedPreferences =
            context.getSharedPreferences(sp, MODE_PRIVATE)
        val nameStudent = sharedPref.getString(nameKey, null)
        val marksStudent = sharedPref.getInt(marksKey.toString(), 0)
        val statusStudent = sharedPref.getBoolean(statusKey.toString(), false)
        return Student(name = nameStudent, marks = marksStudent, status = statusStudent)
    }
}
