package com.lilly.datastore.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.lilly.datastore.repository.PreferenceRepo
import com.lilly.datastore.view.ui.theme.DataStoreTheme
import com.lilly.datastore.viewmodel.PreferenceVM

class SharedPreferenceActivity : ComponentActivity() {
    private val pref = "student-pref"
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(pref, MODE_PRIVATE)
        setContent {
            DataStoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PreferenceStudent(preferenceVM = PreferenceVM(repo = PreferenceRepo(context = application)))
                }
            }
        }
    }
}

@Composable
fun PreferenceStudent(preferenceVM: PreferenceVM) {
    preferenceVM.getDetails()
    val details = preferenceVM.studentDetails.observeAsState()
        Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = details.value?.name.toString())
            Text(text = details.value?.marks.toString())
            Text(text = details.value?.status.toString())
        }
}
