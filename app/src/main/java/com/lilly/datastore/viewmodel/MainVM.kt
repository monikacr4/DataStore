package com.lilly.datastore.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel

class MainVM(application: Application) : AndroidViewModel(application) {
    var name by mutableStateOf("")
    var marks by mutableStateOf("")
    var status by mutableStateOf(false)
}