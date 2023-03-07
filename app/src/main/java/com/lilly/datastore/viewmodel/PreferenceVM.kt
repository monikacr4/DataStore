package com.lilly.datastore.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lilly.datastore.model.Student
import com.lilly.datastore.repository.PreferenceRepo

class PreferenceVM(private val repo: PreferenceRepo): ViewModel(){
    val studentDetails = MutableLiveData<Student?>()

    fun getDetails(){
        studentDetails.value = repo.getFromRepo()
    }

    fun saveDetails(student: Student){
        repo.saveToRepo(student)
    }
}