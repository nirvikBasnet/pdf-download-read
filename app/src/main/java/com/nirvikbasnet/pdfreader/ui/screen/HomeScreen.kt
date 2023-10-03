package com.nirvikbasnet.pdfreader.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    val url = remember { mutableStateOf("") }

    //need to encode because url contains :// which will throw an exception
    val encodedUrl = URLEncoder.encode(url.value,"utf-8")

    Column (modifier = Modifier.padding(5.dp)
        .fillMaxWidth().fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = url.value, onValueChange = {url.value=it}, label = {
            Text("URL")
        })
        Button(modifier = Modifier.fillMaxWidth(), onClick = {navController.navigate("LoadURLScreen/$encodedUrl")}){
            Text("View")
        }
        Button(modifier = Modifier.fillMaxWidth(),onClick = {}){
            Text("Download")
        }
    }

}