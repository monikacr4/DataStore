package com.lilly.datastore.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lilly.datastore.pref.StudentPrefImpl
import com.lilly.datastore.view.ui.theme.DataStoreTheme

class DataStoreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataStoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GetName()
                }
            }
        }
    }
}

@Composable
fun GetName() {
    val context = LocalContext.current
    val dataStore = StudentPrefImpl(context)
    val getName = dataStore.nameFlow.collectAsState(initial = "")
    val getMarks = dataStore.marksFlow.collectAsState(initial = 0)
    val getStatus = dataStore.statusFlow.collectAsState(initial = false)
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        Text(text = getName.value, fontSize = 18.sp)
        Text(text = getMarks.value.toString(), fontSize = 18.sp)
        Text(text = getStatus.value.toString(), fontSize = 18.sp)
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = {
            context.startActivity(Intent(context, SharedPreferenceActivity::class.java))
        }
        ) {
            Text("Shared Preference")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    DataStoreTheme {
        GetName()
    }
}