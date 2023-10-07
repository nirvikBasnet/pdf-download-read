package com.nirvikbasnet.pdfreader

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.nirvikbasnet.pdfreader.data.PreferencesManager
import com.nirvikbasnet.pdfreader.ui.navigation.PdfReaderNavigation
import com.nirvikbasnet.pdfreader.ui.navigation.bottomNavigation.BottomNavBar
import com.nirvikbasnet.pdfreader.ui.screen.MainScreen
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.DownloadPdfViewModel
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.PdfListViewModel

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MainScreen()

            }
        }
    }








