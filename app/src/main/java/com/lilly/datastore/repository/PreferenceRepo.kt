package com.lilly.datastore.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.lilly.datastore.model.Student

class PreferenceRepo(private val context: Context) {
    private val nameKey: String = "name"
    private val marksKey: String = "marks"

    companion object{
        private const val sp = "pref"
    }

    fun saveToRepo(student: Student){
        val sharedPref: SharedPreferences =
            context.getSharedPreferences(Companion.sp, MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(nameKey, student.name)
        editor.putString(marksKey, student.marks.toString())
        editor.apply()
    }

    fun getFromRepo():Student {
        val sharedPref: SharedPreferences =
            context.getSharedPreferences(sp, MODE_PRIVATE)
        val nameStudent = sharedPref.getString(nameKey, null)
        val marksStudent = sharedPref.getString(marksKey, null)
        return Student(name = nameStudent, marks = marksStudent)
    }
}