package com.nirvikbasnet.pdfreader

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.nirvikbasnet.pdfreader.ui.navigation.PdfReaderNavigation
import com.nirvikbasnet.pdfreader.ui.navigation.bottomNavigation.BottomNavBar
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.DownloadPdfViewModel
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.PdfListViewModel

class MainActivity : ComponentActivity() {

    private val dir : Uri
        get() {
            TODO()
        }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Scaffold(

                ){
                    val downloadPdfViewModel = ViewModelProvider(this).get(DownloadPdfViewModel::class.java)
                    val pdfListViewModel = ViewModelProvider(this).get(PdfListViewModel::class.java)

                    PdfReaderNavigation(it,dir,downloadPdfViewModel,pdfListViewModel)

                }


            }
        }
    }








