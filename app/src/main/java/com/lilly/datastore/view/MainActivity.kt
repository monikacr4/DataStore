package com.lilly.datastore.view

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lilly.datastore.ui.theme.DataStoreTheme
import com.lilly.datastore.viewmodel.MainVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataStoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DataInput(mainVM = MainVM(application = Application()))
                }
            }
        }
    }
}

@Composable
fun DataInput(mainVM: MainVM){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(40.dp),
        verticalArrangement = Arrangement.Center
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Name")
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(value = mainVM.name,
                onValueChange = {mainVM.name = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }
        Spacer(modifier = Modifier.height(26.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Marks")
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(value = mainVM.marks,
                onValueChange = {mainVM.marks = it},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                    context.startActivity(Intent(context, SharedPreferenceActivity::class.java))
            },
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(text = "Evaluate")
        }
    }
}

@Preview
@Composable
fun DefaultPreview(){
    DataInput(mainVM = MainVM(application = Application()))
}