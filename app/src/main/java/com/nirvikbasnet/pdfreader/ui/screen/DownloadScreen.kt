package com.nirvikbasnet.pdfreader.ui.screen

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nirvikbasnet.pdfreader.data.PreferencesManager
import com.nirvikbasnet.pdfreader.ui.navigation.bottomNavigation.BottomNavBar
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.DownloadPdfViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DownloadScreen(context: Context, navController: NavController, viewModel: DownloadPdfViewModel){
    val url = remember { mutableStateOf("") }
    val preferencesManager = remember { PreferencesManager(context) }
    val data = remember { mutableStateOf(preferencesManager.getData("dir", "")) }


    var selectedDirectoryUri by remember { mutableStateOf<Uri?>(null) }
    var context = LocalContext.current

    //SAF, open directory and select a place to save
    val directoryPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocumentTree()
    ) { uri ->
        selectedDirectoryUri = uri
        data.value = uri.toString()
        preferencesManager.saveData("dir", uri.toString())

    }
//TODO, for testing i've removed the below
   // val isDownloadEnabled = selectedDirectoryUri != null

    Scaffold {
        Column (modifier = Modifier.padding(5.dp)
            .fillMaxWidth().fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = url.value, onValueChange = {url.value=it}, label = {
                Text("URL")
            })
            Button(modifier = Modifier.fillMaxWidth(),onClick = { directoryPickerLauncher.launch(null)}){
                Text("Select Location to save PDF")
            }


            Button(modifier = Modifier.fillMaxWidth(),
                onClick = {  viewModel.downloadPdf(context, url.value, "ABC", selectedDirectoryUri)},
//                enabled = isDownloadEnabled
                ){
                Text("Download")
            }

        }


    }

}

