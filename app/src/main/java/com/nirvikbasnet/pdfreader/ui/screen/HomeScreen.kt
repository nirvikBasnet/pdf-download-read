package com.nirvikbasnet.pdfreader.ui.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.DownloadPdfViewModel
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController,viewModel: DownloadPdfViewModel){
    val url = remember { mutableStateOf("") }

    var selectedDirectoryUri by remember { mutableStateOf<Uri?>(null) }
    var context = LocalContext.current

    //need to encode because url contains :// which will throw an exception
    val encodedUrl = URLEncoder.encode(url.value,"utf-8")

    //SAF, open directory and select a place to save
    val directoryPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocumentTree()
    ) { uri ->
        selectedDirectoryUri = uri
    }

    Column (modifier = Modifier.padding(5.dp)
        .fillMaxWidth().fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = url.value, onValueChange = {url.value=it}, label = {
            Text("URL")
        })
        Button(modifier = Modifier.fillMaxWidth(),onClick = { directoryPickerLauncher.launch(null)}){
            Text("Selected Directory")
        }
        Button(modifier = Modifier.fillMaxWidth(),onClick = {  viewModel.downloadPdf(context, url.value, "ABC", selectedDirectoryUri)}){
            Text("Download")
        }

    }


}

